package tech.chaosmin.framework.cdpt

import tech.chaosmin.framework.Application

/**
 * @author Romani min
 * @since 2021/8/10 22:36
 */
open class CdptApplication : Application<CdptApplication>()

fun main(args: Array<String>) = CdptApplication().start(CdptApplication::class.java, args)