implementation 'com.google.android.gms:play-services-ads:20.6.0'

private AdManagerAdView bannerAd;
private AdManagerInterstitialAd interstitialAd;

 MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
                loadBannerAd();
                loadInterstitialAd();
            }
        });


private void loadBannerAd() {
        bannerAd = findViewById(R.id.bannerAd);
        AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
        bannerAd.loadAd(adRequest);
    }


<string name="banner_id_admob">/6499/example/banner</string>

<uses-permission android:name="android.permission.INTERNET" />
<meta-data
            android:name="com.google.android.gms.ads.APPLICATION_ID"
            android:value="ca-app-pub-3940256099942544~3347511713"/>


<com.google.android.gms.ads.admanager.AdManagerAdView
        xmlns:ads="http://schemas.android.com/apk/res-auto"
        android:id="@+id/bannerAd"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_centerHorizontal="true"
        android:layout_alignParentBottom="true"
        ads:adSize="BANNER"
        ads:adUnitId="@string/banner_id_admob">

private void loadInterstitialAd() {
        AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();

        AdManagerInterstitialAd.load(this,getString(R.string.interstitial_id_admob), adRequest,
                new AdManagerInterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull AdManagerInterstitialAd interstitialAd) {
                        // The mAdManagerInterstitialAd reference will be null until
                        // an ad is loaded.
                        interstitialAd = interstitialAd;
                        final AdManagerInterstitialAd interstitialAds = interstitialAd;

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                Log.i("TAG", "onAdLoaded");
                                if (interstitialAds != null) {
                                    interstitialAds.show(MainActivity.this);
                                } else {
                                    Log.d("TAG", "The interstitial ad wasn't ready yet.");
                                }
                            }
                        }, 1000*30);
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.i("TAG", loadAdError.getMessage());
                        interstitialAd = null;
                    }
                });
    }
