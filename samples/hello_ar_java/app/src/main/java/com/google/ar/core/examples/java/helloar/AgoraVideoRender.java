package com.google.ar.core.examples.java.helloar;

import android.util.Log;

import java.nio.ByteBuffer;

import io.agora.rtc.mediaio.IVideoRenderer;
import io.agora.rtc.mediaio.MediaIO;

/**
 * Created by eaglewangy on 03/01/2018.
 */

public class AgoraVideoRender implements IVideoRenderer {
    private int mUid;

    public AgoraVideoRender() {
        mUid = 0;
    }

    public AgoraVideoRender(int uid) {
        mUid = uid;
    }

    public int getUid() {
        return mUid;
    }

    public void setUid(int uid) {
        this.mUid = uid;
    }

    @Override
    public boolean onInitialize() {
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

    @Override
    public int getPixelFormat() {
        return MediaIO.PixelFormat.I420.intValue();
    }

    @Override
    public void consumeByteBufferFrame(ByteBuffer byteBuffer, int i, int i1, int i2, int i3, long l) {
    }

    @Override
    public void consumeByteArrayFrame(byte[] bytes, int i, int i1, int i2, int i3, long l) {
        //Log.e("AgoraVideoRender", "consumeByteArrayFrame");
    }

    @Override
    public void consumeTextureFrame(int i, int i1, int i2, int i3, int i4, long l, float[] floats) {

    }
}
