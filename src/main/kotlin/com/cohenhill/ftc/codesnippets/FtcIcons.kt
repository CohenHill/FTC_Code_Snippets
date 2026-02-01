package com.cohenhill.ftc.codesnippets

import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

object FtcIcons {
    @JvmField val Auto: Icon = IconLoader.getIcon("/icons/auto.svg", FtcIcons::class.java)
    @JvmField val TeleOp: Icon = IconLoader.getIcon("/icons/teleop.svg", FtcIcons::class.java)
    @JvmField val Subsystem: Icon = IconLoader.getIcon("/icons/subsystem.svg", FtcIcons::class.java)
    @JvmField val Command: Icon = IconLoader.getIcon("/icons/command.svg", FtcIcons::class.java)
    @JvmField val Robot: Icon = IconLoader.getIcon("/icons/robot.svg", FtcIcons::class.java)
}
