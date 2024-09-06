package com.proxy.service.core.service.apihttp

import com.proxy.service.api.CloudSystem
import com.proxy.service.apihttp.base.ApiHttpService
import com.proxy.service.apihttp.base.init.ApiConfig
import com.proxy.service.core.framework.log.CsLogger

/**
 * @author: cangHX
 * @data: 2024/7/18 16:42
 * @desc: http 网络框架入口
 */
object CsApi {

    private var service: ApiHttpService? = null

    private fun getService(): ApiHttpService? {
        if (service == null) {
            service = CloudSystem.getService(ApiHttpService::class.java)
        }
        if (service == null) {
            CsLogger.e("Please check to see if it is referenced. <com.tal.sc.reader:service-apihttp:xxx>")
        }
        return service
    }

    private var config: ApiConfig? = null

    /**
     * 网络库初始化
     * */
    fun init(config: ApiConfig) {
        CsApi.config = config
    }

    /**
     * 获取请求接口
     * */
    fun <T> getService(service: Class<T>): T? {
        config?.let {
            val api = getService()
            api?.init(it)
            return api?.getService(service)
        } ?: let {
            CsLogger.e("Please check whether initialization has been performed.")
        }
        return null
    }
}