package com.servioticy.CBKafkaBridge;

import com.couchbase.client.core.message.dcp.MutationMessage;
import com.couchbase.client.deps.io.netty.util.CharsetUtil;
import com.couchbase.kafka.DCPEvent;
import com.couchbase.kafka.coder.AbstractEncoder;
import kafka.utils.VerifiableProperties;

public class ServioticyEncoder extends AbstractEncoder {
    public ServioticyEncoder(final VerifiableProperties properties) {
        super(properties);
    }

    @Override
    public byte[] toBytes(final DCPEvent dcpEvent) {
        MutationMessage message = (MutationMessage)dcpEvent.message();
	String key = message.key();
	String[] splits = key.split("-");
	String soId = splits[0];
	String streamId = splits[1];
	String result = "{\"opid\": \"2727\", \"soid\": \"" + soId +
                        "\", \"streamid\": \"" + streamId + "\", \"su\": " + 
                        message.content().toString(CharsetUtil.UTF_8) + "}";
        return result.getBytes();
    }
}
