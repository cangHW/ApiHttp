package com.proxy.service.threadpool.base.thread.callback

/**
 * @author: cangHX
 * @data: 2024/6/13 19:09
 * @desc:
 */
interface OnRunCallback<T> {

    fun onCallback(value: T)

}