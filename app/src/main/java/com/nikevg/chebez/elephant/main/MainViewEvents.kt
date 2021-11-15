package com.nikevg.chebez.elephant.main

import com.nikevg.chebez.elephant.base.ViewEvent

class OpenPurchaseWithSpeakEvent(val results: String?) : ViewEvent

object CheckMicPermissionEvent : ViewEvent
object MicPermissionDeniedErrorEvent : ViewEvent
object NetworkErrorEvent : ViewEvent
object OpenPurchaseEvent : ViewEvent
object ShowElephantsEvent : ViewEvent
object UnknownErrorEvent : ViewEvent
