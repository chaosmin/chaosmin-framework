package tech.chaosmin.framework.auth

import tech.chaosmin.framework.Application

/**
 * @author Romani min
 * @since 2021/8/10 22:38
 */
open class AuthApplication : Application<AuthApplication>()

fun main(args: Array<String>) = AuthApplication().start(AuthApplication::class.java, args)