package tech.chaosmin.framework.payment

import tech.chaosmin.framework.Application

/**
 * @author Romani min
 * @since 2021/8/10 22:11
 */
open class PaymentApplication : Application<PaymentApplication>()

fun main(args: Array<String>) = PaymentApplication().start(PaymentApplication::class.java, args)