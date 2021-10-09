package com.learn;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

public class HttpInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel c) throws Exception {
        ChannelPipeline cp = c.pipeline();
        cp.addLast(new HttpServerCodec());
        cp.addLast(new HttpObjectAggregator(1024*1024));
        cp.addLast(new HttpHandler());
    }
}
