package com.colin969.openfire.plugins.kongregate;

import org.jivesoftware.openfire.IQHandlerInfo;
import org.jivesoftware.openfire.auth.UnauthorizedException;
import org.jivesoftware.openfire.handler.IQHandler;
import org.xmpp.packet.IQ;
import org.xmpp.packet.PacketError;

public class KongregateIQHandler extends IQHandler {

    private IQHandlerInfo info;

    public KongregateIQHandler() {
        super("KongregateIQHandler");
        info = new IQHandlerInfo("query","kongregate:iq:msg");   
    }

    @Override
    public IQHandlerInfo getInfo() {
        return info;
    }

    @Override
    public IQ handleIQ(IQ packet) throws UnauthorizedException {

        IQ result = IQ.createResultIQ(packet);

        IQ.Type type = packet.getType();

        if (type.equals(IQ.Type.get)) {
            result.setChildElement("query", "kongregate:iq:msg");
            //Do stuff you according to get and return the query result by adding to result
        }
        else if(type.equals(IQ.Type.set))
        {
            result.setChildElement("query", "kongregate:iq:msg");
            //Do stuff you according to set and return the query result by adding to result
        }
        else{
            result.setChildElement(packet.getChildElement().createCopy());
            result.setError(PacketError.Condition.not_acceptable);
        }
        return result;
    }   

}