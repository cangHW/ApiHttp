package com.proxy.service.core.framework.system.resource

import com.proxy.service.core.framework.app.CsAppUtils
import com.proxy.service.core.framework.context.CsContextManager

/**
 * @author: cangHX
 * @data: 2024/4/28 17:33
 * @desc:
 */
object CsDpUtils {

    /**
     * dp 转 px
     * */
    fun dip2px(dipValue: Float): Int {
        val dm = CsContextManager.getApplication().resources.displayMetrics
        val density = dm.density
        return (dipValue * density + 0.5f).toInt()
    }

    /**
     * px 转 dp
     * */
    fun px2dip(pxValue: Float): Int {
        val dm = CsContextManager.getApplication().resources.displayMetrics
        val density = dm.density
        return (pxValue / density + 0.5f).toInt()
    }

    /**
     * 根据字符串找到 dimen 中对应的值并转化为 px
     * */
    fun getDimenPxByValue(value: String): Int {
        val resources = CsContextManager.getApplication().resources
        val id = resources.getIdentifier("size_${value}dp", "dimen", CsAppUtils.getPackageName())
        return if (id == 0) {
            try {
                value.split("_").let {
                    if (it.isEmpty()) {
                        0
                    } else {
                        it[0].toInt()
                    }
                }
            } catch (throwable: Throwable) {
                0
            }
        } else {
            resources.getDimension(id).toInt()
        }
    }

}