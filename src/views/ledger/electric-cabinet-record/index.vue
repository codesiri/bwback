<template>
  <div class="app-container">
    <div class="search-container">
      <el-form ref="queryFormRef" :model="queryParams" :inline="true">
        <el-form-item class="search-buttons">
          <el-button type="primary" icon="search" @click="handleQuery">搜索</el-button>
          <el-button icon="refresh" @click="handleResetQuery">重置</el-button>
        </el-form-item>
      </el-form>
    </div>

    <el-card shadow="never">
      <div class="mb-10px">
        <el-button
            v-hasPerm="['ledger:electric-cabinet-record:add']"
            type="success"
            icon="plus"
            @click="handleOpenDialog()"
        >新增</el-button>
        <el-button
            v-hasPerm="['ledger:electric-cabinet-record:delete']"
            type="danger"
            :disabled="removeIds.length === 0"
            icon="delete"
            @click="handleDelete()"
        >删除</el-button>
      </div>

      <el-table
        ref="dataTableRef"
        v-loading="loading"
        :data="pageData"
        highlight-current-row
        border
        @selection-change="handleSelectionChange"
      >
        <el-table-column type="selection" width="55" align="center" />
              <el-table-column
                key="id"
                label="序号"
                prop="id"
                min-width="150"
                align="center"
              />
              <el-table-column
                key="ecrInspectDate"
                label="巡检日期"
                prop="ecrInspectDate"
                min-width="150"
                align="center"
              />
              <el-table-column
                key="ecrInspectPerson"
                label="巡检人"
                prop="ecrInspectPerson"
                min-width="150"
                align="center"
              />
              <el-table-column
                key="ecrInspectItem"
                label="巡检项目"
                prop="ecrInspectItem"
                min-width="150"
                align="center"
              />
              <el-table-column
                key="ecrInspectResult"
                label="巡检结果"
                prop="ecrInspectResult"
                min-width="150"
                align="center"
              />
              <el-table-column
                key="ecrProblemDesc"
                label="问题描述"
                prop="ecrProblemDesc"
                min-width="150"
                align="center"
              />
              <el-table-column
                key="ecrMeasure"
                label="处理措施"
                prop="ecrMeasure"
                min-width="150"
                align="center"
              />
              <el-table-column
                key="ecrHandler"
                label="处理人"
                prop="ecrHandler"
                min-width="150"
                align="center"
              />
              <el-table-column
                key="ecrFactory"
                label="所属工厂"
                prop="ecrFactory"
                min-width="150"
                align="center"
              />
              <el-table-column
                key="ecrReserve1"
                label="备用1"
                prop="ecrReserve1"
                min-width="150"
                align="center"
              />
              <el-table-column
                key="ecrReserve2"
                label="备用2"
                prop="ecrReserve2"
                min-width="150"
                align="center"
              />
              <el-table-column
                key="ecrReserve3"
                label="备用3"
                prop="ecrReserve3"
                min-width="150"
                align="center"
              />
        <el-table-column fixed="right" label="操作" width="220">
          <template #default="scope">
            <el-button
                v-hasPerm="['ledger:electric-cabinet-record:edit']"
                type="primary"
                size="small"
                link
                icon="edit"
                @click="handleOpenDialog(scope.row.id)"
            >
              编辑
            </el-button>
            <el-button
                v-hasPerm="['ledger:electric-cabinet-record:delete']"
                type="danger"
                size="small"
                link
                icon="delete"
                @click="handleDelete(scope.row.id)"
            >
              删除
            </el-button>
          </template>
        </el-table-column>
      </el-table>

      <pagination
          v-if="total > 0"
          v-model:total="total"
          v-model:page="queryParams.pageNum"
          v-model:limit="queryParams.pageSize"
          @pagination="handleQuery()"
      />
    </el-card>

    <!-- 电器日常巡检记录表单弹窗 -->
    <el-dialog
        v-model="dialog.visible"
        :title="dialog.title"
        width="500px"
        @close="handleCloseDialog"
    >
      <el-form ref="dataFormRef" :model="formData" :rules="rules" label-width="100px">
                <el-form-item label="序号" prop="id">
                      <el-input
                          v-model="formData.id"
                          placeholder="序号"
                      />
                </el-form-item>

                <el-form-item label="巡检日期" prop="ecrInspectDate">
                      <el-date-picker
                          class="!w-[240px]"
                          v-model="formData.ecrInspectDate"
                          type="date"
                          placeholder="巡检日期"
                          value-format="YYYY-MM-DD"
                      />
                </el-form-item>

                <el-form-item label="巡检人" prop="ecrInspectPerson">
                      <el-input
                          v-model="formData.ecrInspectPerson"
                          placeholder="巡检人"
                      />
                </el-form-item>

                <el-form-item label="巡检项目" prop="ecrInspectItem">
                      <el-input
                          v-model="formData.ecrInspectItem"
                          placeholder="巡检项目"
                      />
                </el-form-item>

                <el-form-item label="巡检结果" prop="ecrInspectResult">
                      <el-input
                          v-model="formData.ecrInspectResult"
                          placeholder="巡检结果"
                      />
                </el-form-item>

                <el-form-item label="问题描述" prop="ecrProblemDesc">
                      <el-input
                          v-model="formData.ecrProblemDesc"
                          placeholder="问题描述"
                      />
                </el-form-item>

                <el-form-item label="处理措施" prop="ecrMeasure">
                      <el-input
                          v-model="formData.ecrMeasure"
                          placeholder="处理措施"
                      />
                </el-form-item>

                <el-form-item label="处理人" prop="ecrHandler">
                      <el-input
                          v-model="formData.ecrHandler"
                          placeholder="处理人"
                      />
                </el-form-item>

                <el-form-item label="所属工厂" prop="ecrFactory">
                      <el-input
                          v-model="formData.ecrFactory"
                          placeholder="所属工厂"
                      />
                </el-form-item>

                <el-form-item label="备用1" prop="ecrReserve1">
                      <el-input
                          v-model="formData.ecrReserve1"
                          placeholder="备用1"
                      />
                </el-form-item>

                <el-form-item label="备用2" prop="ecrReserve2">
                      <el-input
                          v-model="formData.ecrReserve2"
                          placeholder="备用2"
                      />
                </el-form-item>

                <el-form-item label="备用3" prop="ecrReserve3">
                      <el-input
                          v-model="formData.ecrReserve3"
                          placeholder="备用3"
                      />
                </el-form-item>

      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button type="primary" @click="handleSubmit()">确定</el-button>
          <el-button @click="handleCloseDialog()">取消</el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>

<script setup lang="ts">
  defineOptions({
    name: "ElectricCabinetRecord",
    inheritAttrs: false,
  });

  import ElectricCabinetRecordAPI, { ElectricCabinetRecordPageVO, ElectricCabinetRecordForm, ElectricCabinetRecordPageQuery } from "@/api/ledger/electric-cabinet-record-api";

  const queryFormRef = ref();
  const dataFormRef = ref();

  const loading = ref(false);
  const removeIds = ref<number[]>([]);
  const total = ref(0);

  const queryParams = reactive<ElectricCabinetRecordPageQuery>({
    pageNum: 1,
    pageSize: 10,
  });

  // 电器日常巡检记录表格数据
  const pageData = ref<ElectricCabinetRecordPageVO[]>([]);

  // 弹窗
  const dialog = reactive({
    title: "",
    visible: false,
  });

  // 电器日常巡检记录表单数据
  const formData = reactive<ElectricCabinetRecordForm>({});

  // 电器日常巡检记录表单校验规则
  const rules = reactive({
                      id: [{ required: true, message: "请输入序号", trigger: "blur" }],
                      ecrInspectDate: [{ required: true, message: "请输入巡检日期", trigger: "blur" }],
                      ecrInspectPerson: [{ required: true, message: "请输入巡检人", trigger: "blur" }],
                      ecrInspectItem: [{ required: true, message: "请输入巡检项目", trigger: "blur" }],
                      ecrInspectResult: [{ required: true, message: "请输入巡检结果", trigger: "blur" }],
  });

  /** 查询电器日常巡检记录 */
  function handleQuery() {
    loading.value = true;
          ElectricCabinetRecordAPI.getPage(queryParams)
        .then((data) => {
          pageData.value = data.list;
          total.value = data.total;
        })
        .finally(() => {
          loading.value = false;
        });
  }

  /** 重置电器日常巡检记录查询 */
  function handleResetQuery() {
    queryFormRef.value!.resetFields();
    queryParams.pageNum = 1;
    handleQuery();
  }

  /** 行复选框选中记录选中ID集合 */
  function handleSelectionChange(selection: any) {
    removeIds.value = selection.map((item: any) => item.id);
  }

  /** 打开电器日常巡检记录弹窗 */
  function handleOpenDialog(id?: number) {
    dialog.visible = true;
    if (id) {
      dialog.title = "修改电器日常巡检记录";
            ElectricCabinetRecordAPI.getFormData(id).then((data) => {
        Object.assign(formData, data);
      });
    } else {
      dialog.title = "新增电器日常巡检记录";
    }
  }

  /** 提交电器日常巡检记录表单 */
  function handleSubmit() {
    dataFormRef.value.validate((valid: any) => {
      if (valid) {
        loading.value = true;
        const id = formData.id;
        if (id) {
                ElectricCabinetRecordAPI.update(id, formData)
              .then(() => {
                ElMessage.success("修改成功");
                handleCloseDialog();
                handleResetQuery();
              })
              .finally(() => (loading.value = false));
        } else {
                ElectricCabinetRecordAPI.create(formData)
              .then(() => {
                ElMessage.success("新增成功");
                handleCloseDialog();
                handleResetQuery();
              })
              .finally(() => (loading.value = false));
        }
      }
    });
  }

  /** 关闭电器日常巡检记录弹窗 */
  function handleCloseDialog() {
    dialog.visible = false;
    dataFormRef.value.resetFields();
    dataFormRef.value.clearValidate();
    formData.id = undefined;
  }

  /** 删除电器日常巡检记录 */
  function handleDelete(id?: number) {
    const ids = [id || removeIds.value].join(",");
    if (!ids) {
      ElMessage.warning("请勾选删除项");
      return;
    }

    ElMessageBox.confirm("确认删除已选中的数据项?", "警告", {
      confirmButtonText: "确定",
      cancelButtonText: "取消",
      type: "warning",
    }).then(
        () => {
          loading.value = true;
                ElectricCabinetRecordAPI.deleteByIds(ids)
              .then(() => {
                ElMessage.success("删除成功");
                handleResetQuery();
              })
              .finally(() => (loading.value = false));
        },
        () => {
          ElMessage.info("已取消删除");
        }
    );
  }

  onMounted(() => {
    handleQuery();
  });
</script>
