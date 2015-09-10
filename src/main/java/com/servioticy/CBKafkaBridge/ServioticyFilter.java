package com.servioticy.CBKafkaBridge;

import com.couchbase.client.core.message.dcp.MutationMessage;
import com.couchbase.kafka.DCPEvent;
import com.couchbase.kafka.filter.Filter;

public class ServioticyFilter implements Filter {
    @Override
    public boolean pass(final DCPEvent dcpEvent) {
        return dcpEvent.message() instanceof MutationMessage;
    }
}
