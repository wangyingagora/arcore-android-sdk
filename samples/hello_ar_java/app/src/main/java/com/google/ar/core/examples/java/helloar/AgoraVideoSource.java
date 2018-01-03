package com.google.ar.core.examples.java.helloar;

import io.agora.rtc.mediaio.IVideoFrameConsumer;
import io.agora.rtc.mediaio.IVideoSource;
import io.agora.rtc.mediaio.MediaIO;

/**
 * Created by eaglewangy on 03/01/2018.
 */

public class AgoraVideoSource implements IVideoSource {
    private IVideoFrameConsumer mConsumer;

    @Override
    public boolean onInitialize(IVideoFrameConsumer iVideoFrameConsumer) {
        mConsumer = iVideoFrameConsumer;
        return true;
    }

    @Override
    public boolean onStart() {
        return true;
    }

    @Override
    public void onStop() {
    }

    @Override
    public void onDispose() {
    }

    @Override
    public int getBufferType() {
        return MediaIO.BufferType.BYTE_ARRAY.intValue();
    }

    public IVideoFrameConsumer getConsumer() {
        return mConsumer;
    }
}
