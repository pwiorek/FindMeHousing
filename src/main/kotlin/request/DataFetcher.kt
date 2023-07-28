package request

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class DataFetcher {

    companion object {
        private val client = OkHttpClient();

        fun fetch(url: String): Response {
            val request = Request.Builder()
                .url(url)
                .get()
                .addHeader("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:109.0) Gecko/20100101 Firefox/115.0")
                .addHeader("Referer", "https://www.otodom.pl/pl/oferty/wynajem/mieszkanie/poznan?ownerTypeSingleSelect=ALL&distanceRadius=0&locations=%5Bcities_6-1%5D&viewType=listing")
                .addHeader("x-nextjs-data", "1")
                .addHeader("Cookie", "laquesis=remt-615@b#repm-844@b#see-1643@a#sfs-306@a#smr-1304@b#smr-1734@c#smr-1735@b#smr-1788@b#smr-1863@a#smr-2003@b; laquesisff=gre-12226#rer-165#rer-166#rst-73#rst-74; lqstatus=1680127394; OptanonConsent=isGpcEnabled=0&datestamp=Fri+Jul+28+2023+15%3A31%3A39+GMT%2B0200+(Central+European+Summer+Time)&version=202304.1.0&isIABGlobal=false&hosts=&genVendors=V9%3A0%2C&consentId=1116be7e-12d3-48de-b622-a4c854f4691d&interactionCount=1&landingPath=NotLandingPage&groups=C0001%3A1%2CC0002%3A0%2CC0003%3A0%2CC0004%3A0%2Cgad%3A0%2CSTACK42%3A0&geolocation=PL%3B14&AwaitingReconsent=false&browserGpcFlag=0; OptanonAlertBoxClosed=2023-03-29T21:40:24.270Z; eupubconsent-v2=CPpYeHAPpYeHAAcABBENDQCgAAAAAH_AAAYgJTtf_X__b2_r-_5-f_t0eY1P9_7__-0zjhfdl-8N3f_X_L8X52M5vF36tqoKuR4ku3LBIUdlHPHcDVmw6okVryPsbk2cr7NKJ7PEmlMbM2dYGH97n1_z-ZKY7___f_7z_v-v___9____7-3f3__5__--3_e_V_-9zfn9_____9vP___9v-_9_3________3_79_7_D9-eCUYBJhqXEAXZEjATLRhFAiBGFYSFUCgAogAhaIDCB1cFOyuAn1gEgAQCgCcCAEMAKMAAQAACQBIRABIEeCAQAAQCAAEACoQCABjYABYAWAgEAAoBoWKMUAQgSEGRAREKYEBUiQUE9lQglB_oKYQhllgBQaP-KhARrIGKwIhIWDkOCJAS8SSB5ijfAAQgBQCiVCsRSemgIAA.YAAAD_gAAAAA; OTAdditionalConsentString=1~89.2008.2072.2135.2322.2465.2501.2958.2999.3028.3225.3226.3231.3232.3234.3235.3236.3237.3238.3240.3244.3245.3250.3251.3253.3257.3260.3268.3270.3272.3281.3288.3290.3292.3293.3295.3296.3300.3306.3307.3308.3314.3315.3316.3318.3324.3327.3328.3330.3531.3831.3931; __gads=ID=0eeb3116599527bd:T=1689632400:RT=1690445617:S=ALNI_Mar7Lb5-Fo-PsURk2y1zul7N3QPPw; __gpi=UID=00000c3ebb0e6dd7:T=1689632400:RT=1690445617:S=ALNI_MZjme3K45dWUCW3sAEecKhkp4g2Qg; lang=pl; dfp_user_id=7fc73b7e-c519-4fc0-beb1-ebb535698db6")
                .addHeader("TE", "trailers")
                .build()

            return client.newCall(request).execute()
        }
    }


}