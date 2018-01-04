package com.google.ar.core.examples.java.helloar;

import android.util.Log;

import java.nio.ByteBuffer;

import io.agora.rtc.mediaio.IVideoRenderer;
import io.agora.rtc.mediaio.MediaIO;

/**
 * Created by eaglewangy on 03/01/2018.
 */

public class AgoraVideoRender implements IVideoRenderer {
    private OnFrameListener mListener;
    private Peer mPeer;

    public AgoraVideoRender() {
    }

    public AgoraVideoRender(Peer peer, OnFrameListener listener) {
        mPeer = peer;
        mListener = listener;
    }

    public Peer getPeer() {
        return mPeer;
    }

    public void setPeer(Peer mPeer) {
        this.mPeer = mPeer;
    }

    public void setOnFrameListener(OnFrameListener listener) {
        mListener = listener;
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
    public void consumeByteBufferFrame(ByteBuffer byteBuffer, int i, int i1, int i2, int i3, long l) {
        if (mListener != null) {
            mListener.consumeByteBufferFrame(mPeer.uid, byteBuffer, i, i1,i2, i3, l);
        }
    }

    @Override
    public void consumeByteArrayFrame(byte[] bytes, int i, int i1, int i2, int i3, long l) {
        //Log.e("AgoraVideoRender", "consumeByteArrayFrame");
    }

    @Override
    public void consumeTextureFrame(int i, int i1, int i2, int i3, int i4, long l, float[] floats) {

    }

    public interface OnFrameListener {
        void consumeByteBufferFrame(int uid, ByteBuffer data, int pixelFormat, int width, int height, int rotation, long ts);
    }
}
