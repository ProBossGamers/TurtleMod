package com.a2937.turtlemod.packets;

import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

/**
* For messages which can be sent to either Side
*/
public abstract class AbstractBiMessageHandler<T extends IMessage> extends AbstractMessageHandler<T> {

}