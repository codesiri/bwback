import request from "@/utils/request";

const ELECTRICCABINETRECORD_BASE_URL = "/api/v1/electric-cabinet-record";

const ElectricCabinetRecordAPI = {
    /** 获取电器日常巡检记录分页数据 */
    getPage(queryParams?: ElectricCabinetRecordPageQuery) {
        return request<any, PageResult<ElectricCabinetRecordPageVO[]>>({
            url: `${ELECTRICCABINETRECORD_BASE_URL}/page`,
            method: "get",
            params: queryParams,
        });
    },
    /**
     * 获取电器日常巡检记录表单数据
     *
     * @param id 电器日常巡检记录ID
     * @returns 电器日常巡检记录表单数据
     */
    getFormData(id: number) {
        return request<any, ElectricCabinetRecordForm>({
            url: `${ELECTRICCABINETRECORD_BASE_URL}/${id}/form`,
            method: "get",
        });
    },

    /**
     *  添加电器日常巡检记录
     *
     *  @param data 电器日常巡检记录表单数据
     */
    create(data: ElectricCabinetRecordForm) {
        return request({
            url: `${ELECTRICCABINETRECORD_BASE_URL}`,
            method: "post",
            data,
        });
    },

    /**
     * 更新电器日常巡检记录
     *
     * @param id 电器日常巡检记录ID
     * @param data 电器日常巡检记录表单数据
     */
     update(id: string, data: ElectricCabinetRecordForm) {
        return request({
            url: `${ELECTRICCABINETRECORD_BASE_URL}/${id}`,
            method: "put",
            data,
        });
    },

    /**
     * 批量删除电器日常巡检记录，多个以英文逗号(,)分割
     *
     * @param ids 电器日常巡检记录ID字符串，多个以英文逗号(,)分割
     */
     deleteByIds(ids: string) {
        return request({
            url: `${ELECTRICCABINETRECORD_BASE_URL}/${ids}`,
            method: "delete",
        });
    }
}

export default ElectricCabinetRecordAPI;

/** 电器日常巡检记录分页查询参数 */
export interface ElectricCabinetRecordPageQuery extends PageQuery {
}

/** 电器日常巡检记录表单对象 */
export interface ElectricCabinetRecordForm {
    /** 序号 */
    id?:  number;
    /** 巡检日期 */
    ecrInspectDate?:  Date;
    /** 巡检人 */
    ecrInspectPerson?:  string;
    /** 巡检项目 */
    ecrInspectItem?:  string;
    /** 巡检结果 */
    ecrInspectResult?:  string;
    /** 问题描述 */
    ecrProblemDesc?:  string;
    /** 处理措施 */
    ecrMeasure?:  string;
    /** 处理人 */
    ecrHandler?:  string;
    /** 所属工厂 */
    ecrFactory?:  string;
    /** 备用1 */
    ecrReserve1?:  string;
    /** 备用2 */
    ecrReserve2?:  string;
    /** 备用3 */
    ecrReserve3?:  string;
}

/** 电器日常巡检记录分页对象 */
export interface ElectricCabinetRecordPageVO {
    /** 序号 */
    id?: number;
    /** 巡检日期 */
    ecrInspectDate?: Date;
    /** 巡检人 */
    ecrInspectPerson?: string;
    /** 巡检项目 */
    ecrInspectItem?: string;
    /** 巡检结果 */
    ecrInspectResult?: string;
    /** 问题描述 */
    ecrProblemDesc?: string;
    /** 处理措施 */
    ecrMeasure?: string;
    /** 处理人 */
    ecrHandler?: string;
    /** 所属工厂 */
    ecrFactory?: string;
    /** 备用1 */
    ecrReserve1?: string;
    /** 备用2 */
    ecrReserve2?: string;
    /** 备用3 */
    ecrReserve3?: string;
}
