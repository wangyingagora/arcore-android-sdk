package com.google.ar.core.examples.java.helloar;

import android.util.Log;

import java.nio.ByteBuffer;

import io.agora.rtc.mediaio.IVideoRenderer;
import io.agora.rtc.mediaio.MediaIO;

/**
 * Created by eaglewangy on 03/01/2018.
 */

public class AgoraVideoRender implements IVideoRenderer {
    private Peer mPeer;
    private boolean mIsLocal;

    public AgoraVideoRender(int uid, boolean local) {
        mPeer = new Peer();
        mPeer.uid = uid;
        mIsLocal = local;
    }

    public Peer getPeer() {
        return mPeer;
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
        return MediaIO.BufferType.BYTE_BUFFER.intValue();
    }

    @Override
    public int getPixelFormat() {
        // return MediaIO.PixelFormat.RGBA.intValue();
        return 6;
    }

    @Override
    public void consumeByteBufferFrame(ByteBuffer buffer, int format, int width, int height, int rotation, long ts) {
        if (!mIsLocal) {
            mPeer.data = buffer;
            mPeer.width = width;
            mPeer.height = height;
            mPeer.rotation = rotation;
            mPeer.ts = ts;
        }
    }

    @Override
    public void consumeByteArrayFrame(byte[] data, int format, int width, int height, int rotation, long ts) {
        //Log.e("AgoraVideoRender", "consumeByteArrayFrame");
    }

    @Override
    public void consumeTextureFrame(int texId, int format, int width, int height, int rotation, long ts, float[] matrix) {

    }

    public interface OnFrameListener {
        void consumeByteBufferFrame(int uid, ByteBuffer data, int pixelFormat, int width, int height, int rotation, long ts);
    }
}
