package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.util.ParsableByteArray;

public interface WaveSeiCallback {
  public void onSeiFrame(ParsableByteArray seiByteArray);
}
