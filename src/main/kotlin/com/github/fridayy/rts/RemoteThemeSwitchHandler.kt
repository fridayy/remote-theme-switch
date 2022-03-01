package com.github.fridayy.rts

import com.intellij.ide.actions.QuickChangeLookAndFeel
import com.intellij.ide.ui.LafManager
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.http.FullHttpRequest
import io.netty.handler.codec.http.HttpResponseStatus
import io.netty.handler.codec.http.QueryStringDecoder
import org.jetbrains.ide.RestService
import org.slf4j.LoggerFactory
import java.util.*

/**
 * @author benjamin.krenn@leftshift.one - 2/28/22.
 * @since 1.0.0
 */
class RemoteThemeSwitchHandler : RestService() {

    companion object {
        private val log = LoggerFactory.getLogger(this::class.java.enclosingClass)
        private val laf = LafManager.getInstance()

        private const val QUERY_PARAM = "q"
        private const val URI = "rts"
    }

    override fun execute(
        urlDecoder: QueryStringDecoder,
        request: FullHttpRequest,
        context: ChannelHandlerContext
    ): String? {
        val requestedTheme = getStringParameter(QUERY_PARAM, urlDecoder)
        if (requestedTheme == null) {
            log.warn("Did not receive the expected query parameter ('{}')", QUERY_PARAM)
            sendStatus(HttpResponseStatus.BAD_REQUEST, false, context.channel())
            return null
        }
        val maybeSwitchToTheme = laf.installedLookAndFeels
            .firstOrNull { it.name == requestedTheme }
        if (maybeSwitchToTheme == null) {
            log.warn("Could not find the requested theme '{}'", requestedTheme)
            sendStatus(HttpResponseStatus.NOT_FOUND, false, context.channel())
            return null
        }
        QuickChangeLookAndFeel.switchLafAndUpdateUI(laf, maybeSwitchToTheme, true)
        sendOk(request, context)
        return null
    }

    override fun getServiceName(): String = URI
}