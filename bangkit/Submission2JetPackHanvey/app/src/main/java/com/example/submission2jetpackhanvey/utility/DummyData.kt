package com.example.watchmojo.utility

import com.example.submission2jetpackhanvey.source.ModelDataEntity
import com.example.submission2jetpackhanvey.source.remote.response.ResponseMovie
import com.example.submission2jetpackhanvey.source.remote.response.ResponseTvShow

object DummyData {

    fun generateDataTvShowDummy(): List<ResponseTvShow> {
        val listTvShow = ArrayList<ResponseTvShow>()
        listTvShow.add(
            ResponseTvShow(
                id = 4,
                name = "Fairy Tail",
                dateRelease = "13 April 2019",
                value_score = "Comedy, Romance, Action",
                descript = "Lucy, seorang penyihir, bertemu Eclair, pendeta desa pemilik Batu Phoenix, yang harus ia lindungi. Saat si Carbuncle jahat mengejar mereka, Lucy dan teman-temannya harus mempertahankan Eclair.",
                img_poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lV07a5UwE75jVVuFN1GFEscN7if.jpg",
                preview_image = "https://image.tmdb.org/t/p/original/fANxNeH9JCXPrzNEfriGu1Y95dF.jpg"
            )
        )


        listTvShow.add(
                ResponseTvShow(
                id = 3,
                name = "Dragon Ball",
                dateRelease = "15 September 2019",
                value_score = "Comedy, Action", descript = "Ini adalah kisah baru dari Bangsa Saiyan. Bumi damai setelah Turnamen Kekuasaan. Menyadari bahwa alam semesta masih memiliki banyak orang yang lebih kuat untuk ditemukan, Goku menghabiskan seluruh harinya berlatih untuk mencapai kemampuan bertarungnya yang lebih baik lagi. Lalu suatu hari, Goku dan Vegeta dihadapkan oleh seorang Saiyan lainnya bernama 'Broly' yang belum pernah mereka lihat sebelumnya.",
                img_poster = "https://cdn.euroimg_posters.eu/image/750/img_posters/dragon-ball-z-goku-i28205.jpg",
                preview_image = "https://cdn.euroimg_posters.eu/image/750/img_posters/dragon-ball-z-goku-i28205.jpg"
            )
        )

        listTvShow.add(
                ResponseTvShow(
                id = 7,
                name = "Game of Thrones",
                dateRelease = "10 Juni 2019",
                value_score = "Action, Fantasy", descript = "Berlatar tempat di benua fiktif Westeros dan Essos, Game of Thrones memiliki beberapa plot dan dibintangi oleh sejumlah besar pemeran ansambel serta mengisahkan beberapa alur cerita. Salah satu alur mengisahkan mengenai Takhta Besi di Seven Kingdoms dan rangkaian aliansi dan konflik antar wangsa bangsawan yang saling berlomba untuk mengklaim takhta atau berjuang untuk memerdekakan diri.",
                img_poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
                preview_image = "https://image.tmdb.org/t/p/original/xM8zPWNqwbgCZQNgOOH2YeM7Cu.jpg"
            )
        )
        listTvShow.add(
                ResponseTvShow(
                id = 1,
                name = "Arrow",
                dateRelease = "15 September 2019",
                value_score = "Comedy, Action", descript = "Serial ini menceritakan Oliver Queen, playboy miliuner yang pascaterdampar lima tahun di pulau terpencil, kembali pulang bersenjatakan busur & panah untuk menumpas kejahatan di Kota Star sebagai vigilante rahasia bernama Green Arrow.",
                img_poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
                preview_image = "https://image.tmdb.org/t/p/original/elbLQbocvW9vwrHRjYTSjXr5BX5.jpg"
            )
        )

        listTvShow.add(
                ResponseTvShow(
                id = 2,
                name = "Doom Patrol",
                dateRelease = "20 Januari 2019",
                value_score = "Comedy, Action", descript = "Serial Doom Patrol mengisahkan tentang Elasti-Girl, Negative Man, Robotman, Cyborg, dan Crazy Jane yang mendapat kekuatan dengan cara tragis. Karena hal itu, mereka mengalami cacat fisik dan trauma, lalu diasingkan masyarakat.",
                img_poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/nVN7Dt0Xr78gnJepRsRLaLYklbY.jpg",
                preview_image = "https://image.tmdb.org/t/p/original/sAzw6I1G9JUxm86KokIDdQeWtaq.jpg"
            )
        )

        listTvShow.add(
                ResponseTvShow(
                id = 8,
                name = "Gotham",
                dateRelease = "15 September 2019",
                value_score = "Comedy, Romance", descript = "Gotham adalah serial televisi drama kriminal Amerika Serikat yang dikembangkan oleh Bruno Heller, berdasarkan karakter yang diterbitkan oleh DC Comics dan muncul dalam waralaba Batman, terutama yang milik James Gordon dan Bruce Wayne. Heller dan Danny Cannon, yang mengarahkan pilot, adalah produser eksekutif.",
                img_poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg",
                preview_image = "https://image.tmdb.org/t/p/original/l0U4mNs2vp65AAbfH8v2ymij8T5.jpg"
            )
        )

        listTvShow.add(
                ResponseTvShow(
                id = 5,
                name = "Family Guy",
                dateRelease = "15 September 2019",
                value_score = "Comedy, Romance", descript = "Family Guy mengandalkan konten utamanya yaitu kebanyakan mengangkat mengenai lingkungan sekitar dan isu - isu yang sedang hangat, jadi hampir sebagian besar materi anekdot yang dikeluarkan mereka adalah reka ulang suatu kejadian nyata di tempat lain, seperti yang saya katakan sebelumnya Family Guy juga, mengambil isu sensitif sebagai materi humor mereka, jadi bisa dibilang kemasan mereka yang eye catching dan kartun banget, sekali lagi hanya sebagai bungkus dari konten mereka yang mengandung unsur black comedy yang cukup kental.",
                img_poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xtIFsv0Wpy29Bw7i8gUm1L9x6x8.jpg",
                preview_image = "https://image.tmdb.org/t/p/original/hnK5vODlS1OIIF3Sw6T0RQyt0K3.jpg"
            )
        )

        listTvShow.add(
                ResponseTvShow(
                id = 6,
                name = "The Flash",
                dateRelease = "21 September 2019",
                value_score = "Superhero, Action", descript = "Barry Allen adalah penemuan kembali dari karakter sebelumnya yang disebut Flash, yang muncul dalam buku komik 1940-an sebagai karakter Jay Garrick. Kekuatannya terutama terdiri dari kecepatan manusia super. Berbagai efek lain juga dikaitkan dengan kemampuannya untuk mengontrol kecepatan getaran molekuler, termasuk kemampuannya untuk bergetar dengan kecepatan untuk melewati benda-benda. Flash memakai kostum merah dan emas yang berbeda diperlakukan untuk menahan gesekan dan hambatan angin, secara tradisional menyimpan kostum yang dikompresi di dalam cincin.",
                img_poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg",
                preview_image = "https://image.tmdb.org/t/p/original/rkRqvadAVWzdnrS6bdcUAyJtfpy.jpg"
            )
        )

        listTvShow.add(
                ResponseTvShow(
                id = 9,
                name = "Grey's Anatomy",
                dateRelease = "15 Juli 2019",
                value_score = "Thriller, Action", descript = "Grey's Anatomy dibintangi Ellen Pempeo, sebagai karakter utama yang memerankan dr. Meredith Grey. Dr. Meredith adalah putri ahli bedah umum terkemuka bernama Ellis Grey (Kate Burton). Serial ini menceritakan kehidupan dr. Meredith semenjak menjadi dokter residen hingga akhirnya lulus sebagai dokter bedah.",
                img_poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/jnsvc7gCKocXnrTXF6p03cICTWb.jpg",
                preview_image = "https://image.tmdb.org/t/p/original/ym20NYY99jNH0OzSg4TgLLGsQF9.jpg"
            )
        )

        listTvShow.add(
                ResponseTvShow(
                id = 10,
                name = "Hanna",
                dateRelease = "1 Juli 2019",
                value_score = "Romance, Thriller", descript = "Gadis 16 tahun dibesarkan oleh ayahnya untuk menjadi seorang pembunuh sempurna, dan dikirim dalam misi ke seluruh Eropa, terlacak oleh agen intelijen kejam dan mata-matanya. Star: Cate Blanchett.",
                img_poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/5nSSkcM3TgpllZ7yTyBOQEgAX36.jpg",
                preview_image = "https://image.tmdb.org/t/p/original/ofjZbud67zO2wxQ48VgMVnkECQu.jpg"
            )
        )

        return listTvShow
    }

    fun generateDataMovieDummy(): List<ResponseMovie> {
        val listMovie = ArrayList<ResponseMovie>()

        listMovie.add(
            ResponseMovie(
                id = 10,
                name = "Avengers: Infinity War",
                dateRelease = "25 April 2018",
                value_score = "ACtion, Comedy", descript = "The Avengers dan sekutu mereka harus bersedia mengorbankan segalanya dalam upaya untuk mengalahkan Thanos yang kuat sebelum ia berhasil menghancurkan alam semesta.",
                img_poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                preview_image = "https://image.tmdb.org/t/p/original/kbGO5mHPK7rh516MgAIJUQ9RvqD.jpg"
            )
        )

        listMovie.add(
            ResponseMovie(
                id = 3,
                name = "Aquaman",
                dateRelease = "13 September 2020",
                value_score = "Action, Romance", descript = "Film ini mengungkap asal-usul Arthur Curry, manusia perkasa yang bisa mengendalikan air dan hewan laut. Dari mana ia mendapatkan kekuatannya? Siapa orang tuanya, dan pantaskah dia menjadi seorang raja di 7samudera?",
                img_poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg",
                preview_image = "https://image.tmdb.org/t/p/original/4IWnPqNu34zY4ku3LQJw56MIHFc.jpg"
            )
        )

        listMovie.add(
            ResponseMovie(
                id = 4,
                name = "Bohemian Rhapsody",
                dateRelease = "15 September 2020",
                value_score = "Slice of Life, Romance", descript = "BOHEMIAN RHAPSODY adalah film yang diangkat dari kisah nyata untuk merayakan musik band Rock legendaris QUEEN dan tentunya vokalis mereka yang luar biasa, FREDDIE MERCURY, yang dikenal menentang tradisi dan stereotip hingga menjadi salah satu penghibur yang paling dicintai di planet ini.",
                img_poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
                preview_image = "https://assets.pikiran-rakyat.com/crop/0x0:0x0/750x500/photo/image/2018/12/Queen.JPG"
            )
        )

        listMovie.add(
            ResponseMovie(
                id = 8,
                name = "Glass",
                dateRelease = "2 Juni 2019",
                value_score = "Action, Romance", descript = "Film Glass akan melanjutkan kisah pencarian Kevin Wendell Crumb yang hmelarikan diri setelah menculik para gadis. Kevin Wendel Crumbang memiliki 20 kepribadian dalam satu jiwa ini bisa berubah menjadi seorang monster saat pribadinya yang bernama The Beast muncul.",
                img_poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
                preview_image = "https://image.tmdb.org/t/p/original/ngBFDOsx13sFXiMweDoL54XYknR.jpg"
            )
        )

        listMovie.add(
            ResponseMovie(
                id = 9,
                name = "How to Train Your Dragon",
                dateRelease = "15 September 2019",
                value_score = "Comedy, Romance", descript = "Seorang Viking muda menentang tradisi ketika ia berteman dengan seekor naga bernama Toothless. Bersama, para pahlawan tidak biasa ini melawan segala rintangan demi menyelamatkan kedua dunia mereka.",
                img_poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg",
                preview_image = "https://image.tmdb.org/t/p/original/h3KN24PrOheHVYs9ypuOIdFBEpX.jpg"
            )
        )

        listMovie.add(
            ResponseMovie(
                id = 1,
                name = "A Star Is Born",
                dateRelease = "15 Agustus 2018",
                value_score = "Comedy, Romance", descript = "Seorang bintang musik country yang karirnya mulai memudar, Jackson Maine (Bradley Cooper) menemukan sebuah talenta yang sangat berbakat di dalam diri dari seorang musisi muda bernama Ally (Lady Gaga). Maine berhasil mengorbitkan Ally menjadi seorang bintang muda yang menjanjikan. Namun keduanya terlibat hubungan yang lebih jauh dari sekedar mentor dan anak didik. Seiring dengan meroketnya karir dari Ally dan dirinya, Maine mengalami dilema mengenai masalah ini.",
                img_poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg",
                preview_image = "https://image.tmdb.org/t/p/original/wqtaHWOEZ3rXDJ8c6ZZShulbo18.jpg"
            )
        )

        listMovie.add(
            ResponseMovie(
                id = 2,
                name = "Alita: Battle Angel",
                dateRelease = "20 September 2019",
                value_score = "Action, Romance", descript = "Alita terbangun di dunia masa depan yang tak ia kenal, dan tanpa ingatan tentang siapa dirinya. Ia kemudian dibawa oleh Ido, seorang dokter simpatik yang menyadari bahwa di dalam tubuh robot Alita yang sempat terbengkalai itu terdapat hati dan jiwa seorang wanita muda dengan kisah masa lalu yang luar biasa...",
                img_poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg",
                preview_image = "https://image.tmdb.org/t/p/original/aQXTw3wIWuFMy0beXRiZ1xVKtcf.jpg"
            )
        )

        listMovie.add(
            ResponseMovie(
                id = 5,
                name = "Cold Pursuit",
                dateRelease = "15 Maret 2019",
                value_score = "Action, Romance", descript = "Nelson (Liam Neeson) adalah petugas pembersih salju di sebuah kota kecil. Kehidupan tenangnya bersama istri dan anaknya mendadak berubah saat putra mereka terbunuh oleh kartel narkoba...",
                img_poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg",
                preview_image = "https://image.tmdb.org/t/p/original/XAvFHWmWjBeJUQEHBbCcXvzdDZ.jpg"
            )
        )

        listMovie.add(
            ResponseMovie(
                id = 6,
                name = "Creed II",
                dateRelease = "1 April 2019",
                value_score = "Horror, Romance", descript = "Creed II akan melanjutkan kisah Adonis Johnson di dalam serta di luar ring saat ia berhadapan dengan ketenaran, masalah keluarga dan misi yang terus berlanjut untuk menjadi juara sejati.",
                img_poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg",
                preview_image = "https://image.tmdb.org/t/p/original/7568G5PAdQweNfTiuwzlssOxueB.jpg"
            )
        )

        listMovie.add(
            ResponseMovie(
                id = 7,
                name = "Fantastic Beasts",
                dateRelease = "15 September 2019",
                value_score = "Fantasy, Romance", descript = "Film kedua dari seri Fantastic Beasts ini akan melanjutkan kisah Newt Scamander (Eddie Redmayne) untuk kembali menangkap Gellert Grindelwald (Johnny Depp) yang berhasil lolos dari penjara. Bersama Albus Dumbledore (Jude Law) Newt harus bisa menghentikan Grindelwald yang ingin menghancurkan tatanan dunia.",
                img_poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg",
                preview_image = "https://image.tmdb.org/t/p/original/heyvaoVLGC8lcB4FFoz65EBI8xF.jpg"
            )
        )

        return listMovie
    }

    fun generateDummyMovies(): List<ModelDataEntity> {
        val movies = ArrayList<ModelDataEntity>()

        movies.add(
                ModelDataEntity(
                        id = 1,
                        name = "Fairy Tail",
                        dateRelease = "13 April 2019",
                        value_score = "Comedy, Romance, Action",
                        descript = "Lucy, seorang penyihir, bertemu Eclair, pendeta desa pemilik Batu Phoenix, yang harus ia lindungi. Saat si Carbuncle jahat mengejar mereka, Lucy dan teman-temannya harus mempertahankan Eclair.",
                        img_poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lV07a5UwE75jVVuFN1GFEscN7if.jpg",
                        preview_image = "https://image.tmdb.org/t/p/original/fANxNeH9JCXPrzNEfriGu1Y95dF.jpg"
                )
        )
        movies.add(
                ModelDataEntity(
                        id = 2,
                        name = "Fairy Tail",
                        dateRelease = "13 April 2019",
                        value_score = "Comedy, Romance, Action",
                        descript = "Lucy, seorang penyihir, bertemu Eclair, pendeta desa pemilik Batu Phoenix, yang harus ia lindungi. Saat si Carbuncle jahat mengejar mereka, Lucy dan teman-temannya harus mempertahankan Eclair.",
                        img_poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lV07a5UwE75jVVuFN1GFEscN7if.jpg",
                        preview_image = "https://image.tmdb.org/t/p/original/fANxNeH9JCXPrzNEfriGu1Y95dF.jpg"
                )
        )
        movies.add(
                ModelDataEntity(
                        id = 3,
                        name = "Fairy Tail",
                        dateRelease = "13 April 2019",
                        value_score = "Comedy, Romance, Action",
                        descript = "Lucy, seorang penyihir, bertemu Eclair, pendeta desa pemilik Batu Phoenix, yang harus ia lindungi. Saat si Carbuncle jahat mengejar mereka, Lucy dan teman-temannya harus mempertahankan Eclair.",
                        img_poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lV07a5UwE75jVVuFN1GFEscN7if.jpg",
                        preview_image = "https://image.tmdb.org/t/p/original/fANxNeH9JCXPrzNEfriGu1Y95dF.jpg"
                )
        )
        movies.add(
                ModelDataEntity(
                        id = 4,
                        name = "Fairy Tail",
                        dateRelease = "13 April 2019",
                        value_score = "Comedy, Romance, Action",
                        descript = "Lucy, seorang penyihir, bertemu Eclair, pendeta desa pemilik Batu Phoenix, yang harus ia lindungi. Saat si Carbuncle jahat mengejar mereka, Lucy dan teman-temannya harus mempertahankan Eclair.",
                        img_poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lV07a5UwE75jVVuFN1GFEscN7if.jpg",
                        preview_image = "https://image.tmdb.org/t/p/original/fANxNeH9JCXPrzNEfriGu1Y95dF.jpg"
                )
        )
        movies.add(
                ModelDataEntity(
                        id = 5,
                        name = "Fairy Tail",
                        dateRelease = "13 April 2019",
                        value_score = "Comedy, Romance, Action",
                        descript = "Lucy, seorang penyihir, bertemu Eclair, pendeta desa pemilik Batu Phoenix, yang harus ia lindungi. Saat si Carbuncle jahat mengejar mereka, Lucy dan teman-temannya harus mempertahankan Eclair.",
                        img_poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lV07a5UwE75jVVuFN1GFEscN7if.jpg",
                        preview_image = "https://image.tmdb.org/t/p/original/fANxNeH9JCXPrzNEfriGu1Y95dF.jpg"
                )
        )
        movies.add(
                ModelDataEntity(
                        id = 6,
                        name = "Fairy Tail",
                        dateRelease = "13 April 2019",
                        value_score = "Comedy, Romance, Action",
                        descript = "Lucy, seorang penyihir, bertemu Eclair, pendeta desa pemilik Batu Phoenix, yang harus ia lindungi. Saat si Carbuncle jahat mengejar mereka, Lucy dan teman-temannya harus mempertahankan Eclair.",
                        img_poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lV07a5UwE75jVVuFN1GFEscN7if.jpg",
                        preview_image = "https://image.tmdb.org/t/p/original/fANxNeH9JCXPrzNEfriGu1Y95dF.jpg"
                )
        )
        movies.add(
                ModelDataEntity(
                        id = 7,
                        name = "Fairy Tail",
                        dateRelease = "13 April 2019",
                        value_score = "Comedy, Romance, Action",
                        descript = "Lucy, seorang penyihir, bertemu Eclair, pendeta desa pemilik Batu Phoenix, yang harus ia lindungi. Saat si Carbuncle jahat mengejar mereka, Lucy dan teman-temannya harus mempertahankan Eclair.",
                        img_poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lV07a5UwE75jVVuFN1GFEscN7if.jpg",
                        preview_image = "https://image.tmdb.org/t/p/original/fANxNeH9JCXPrzNEfriGu1Y95dF.jpg"
                )
        )
        movies.add(
                ModelDataEntity(
                        id = 8,
                        name = "Fairy Tail",
                        dateRelease = "13 April 2019",
                        value_score = "Comedy, Romance, Action",
                        descript = "Lucy, seorang penyihir, bertemu Eclair, pendeta desa pemilik Batu Phoenix, yang harus ia lindungi. Saat si Carbuncle jahat mengejar mereka, Lucy dan teman-temannya harus mempertahankan Eclair.",
                        img_poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lV07a5UwE75jVVuFN1GFEscN7if.jpg",
                        preview_image = "https://image.tmdb.org/t/p/original/fANxNeH9JCXPrzNEfriGu1Y95dF.jpg"
                )
        )
        movies.add(
                ModelDataEntity(
                        id = 9,
                        name = "Fairy Tail",
                        dateRelease = "13 April 2019",
                        value_score = "Comedy, Romance, Action",
                        descript = "Lucy, seorang penyihir, bertemu Eclair, pendeta desa pemilik Batu Phoenix, yang harus ia lindungi. Saat si Carbuncle jahat mengejar mereka, Lucy dan teman-temannya harus mempertahankan Eclair.",
                        img_poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lV07a5UwE75jVVuFN1GFEscN7if.jpg",
                        preview_image = "https://image.tmdb.org/t/p/original/fANxNeH9JCXPrzNEfriGu1Y95dF.jpg"
                )
        )
        movies.add(
                ModelDataEntity(
                        id = 10,
                        name = "Fairy Tail",
                        dateRelease = "13 April 2019",
                        value_score = "Comedy, Romance, Action",
                        descript = "Lucy, seorang penyihir, bertemu Eclair, pendeta desa pemilik Batu Phoenix, yang harus ia lindungi. Saat si Carbuncle jahat mengejar mereka, Lucy dan teman-temannya harus mempertahankan Eclair.",
                        img_poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lV07a5UwE75jVVuFN1GFEscN7if.jpg",
                        preview_image = "https://image.tmdb.org/t/p/original/fANxNeH9JCXPrzNEfriGu1Y95dF.jpg"
                )
        )

        return movies
    }

    fun generateDummyTv(): List<ModelDataEntity> {
        val tvShows = ArrayList<ModelDataEntity>()

        tvShows.add(
                ModelDataEntity(
                        id = 1,
                        name = "Fairy Tail",
                        dateRelease = "13 April 2019",
                        value_score = "Comedy, Romance, Action",
                        descript = "Lucy, seorang penyihir, bertemu Eclair, pendeta desa pemilik Batu Phoenix, yang harus ia lindungi. Saat si Carbuncle jahat mengejar mereka, Lucy dan teman-temannya harus mempertahankan Eclair.",
                        img_poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lV07a5UwE75jVVuFN1GFEscN7if.jpg",
                        preview_image = "https://image.tmdb.org/t/p/original/fANxNeH9JCXPrzNEfriGu1Y95dF.jpg"
                )
        )
        tvShows.add(
                ModelDataEntity(
                        id = 2,
                        name = "Fairy Tail",
                        dateRelease = "13 April 2019",
                        value_score = "Comedy, Romance, Action",
                        descript = "Lucy, seorang penyihir, bertemu Eclair, pendeta desa pemilik Batu Phoenix, yang harus ia lindungi. Saat si Carbuncle jahat mengejar mereka, Lucy dan teman-temannya harus mempertahankan Eclair.",
                        img_poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lV07a5UwE75jVVuFN1GFEscN7if.jpg",
                        preview_image = "https://image.tmdb.org/t/p/original/fANxNeH9JCXPrzNEfriGu1Y95dF.jpg"
                )
        )
        tvShows.add(
                ModelDataEntity(
                        id = 3,
                        name = "Fairy Tail",
                        dateRelease = "13 April 2019",
                        value_score = "Comedy, Romance, Action",
                        descript = "Lucy, seorang penyihir, bertemu Eclair, pendeta desa pemilik Batu Phoenix, yang harus ia lindungi. Saat si Carbuncle jahat mengejar mereka, Lucy dan teman-temannya harus mempertahankan Eclair.",
                        img_poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lV07a5UwE75jVVuFN1GFEscN7if.jpg",
                        preview_image = "https://image.tmdb.org/t/p/original/fANxNeH9JCXPrzNEfriGu1Y95dF.jpg"
                )
        )
        tvShows.add(
                ModelDataEntity(
                        id = 4,
                        name = "Fairy Tail",
                        dateRelease = "13 April 2019",
                        value_score = "Comedy, Romance, Action",
                        descript = "Lucy, seorang penyihir, bertemu Eclair, pendeta desa pemilik Batu Phoenix, yang harus ia lindungi. Saat si Carbuncle jahat mengejar mereka, Lucy dan teman-temannya harus mempertahankan Eclair.",
                        img_poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lV07a5UwE75jVVuFN1GFEscN7if.jpg",
                        preview_image = "https://image.tmdb.org/t/p/original/fANxNeH9JCXPrzNEfriGu1Y95dF.jpg"
                )
        )
        tvShows.add(
                ModelDataEntity(
                        id = 5,
                        name = "Fairy Tail",
                        dateRelease = "13 April 2019",
                        value_score = "Comedy, Romance, Action",
                        descript = "Lucy, seorang penyihir, bertemu Eclair, pendeta desa pemilik Batu Phoenix, yang harus ia lindungi. Saat si Carbuncle jahat mengejar mereka, Lucy dan teman-temannya harus mempertahankan Eclair.",
                        img_poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lV07a5UwE75jVVuFN1GFEscN7if.jpg",
                        preview_image = "https://image.tmdb.org/t/p/original/fANxNeH9JCXPrzNEfriGu1Y95dF.jpg"
                )
        )
        tvShows.add(
                ModelDataEntity(
                        id = 6,
                        name = "Fairy Tail",
                        dateRelease = "13 April 2019",
                        value_score = "Comedy, Romance, Action",
                        descript = "Lucy, seorang penyihir, bertemu Eclair, pendeta desa pemilik Batu Phoenix, yang harus ia lindungi. Saat si Carbuncle jahat mengejar mereka, Lucy dan teman-temannya harus mempertahankan Eclair.",
                        img_poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lV07a5UwE75jVVuFN1GFEscN7if.jpg",
                        preview_image = "https://image.tmdb.org/t/p/original/fANxNeH9JCXPrzNEfriGu1Y95dF.jpg"
                )
        )
        tvShows.add(
                ModelDataEntity(
                        id = 7,
                        name = "Fairy Tail",
                        dateRelease = "13 April 2019",
                        value_score = "Comedy, Romance, Action",
                        descript = "Lucy, seorang penyihir, bertemu Eclair, pendeta desa pemilik Batu Phoenix, yang harus ia lindungi. Saat si Carbuncle jahat mengejar mereka, Lucy dan teman-temannya harus mempertahankan Eclair.",
                        img_poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lV07a5UwE75jVVuFN1GFEscN7if.jpg",
                        preview_image = "https://image.tmdb.org/t/p/original/fANxNeH9JCXPrzNEfriGu1Y95dF.jpg"
                )
        )
        tvShows.add(
                ModelDataEntity(
                        id = 8,
                        name = "Fairy Tail",
                        dateRelease = "13 April 2019",
                        value_score = "Comedy, Romance, Action",
                        descript = "Lucy, seorang penyihir, bertemu Eclair, pendeta desa pemilik Batu Phoenix, yang harus ia lindungi. Saat si Carbuncle jahat mengejar mereka, Lucy dan teman-temannya harus mempertahankan Eclair.",
                        img_poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lV07a5UwE75jVVuFN1GFEscN7if.jpg",
                        preview_image = "https://image.tmdb.org/t/p/original/fANxNeH9JCXPrzNEfriGu1Y95dF.jpg"
                )
        )
        tvShows.add(
                ModelDataEntity(
                        id = 9,
                        name = "Fairy Tail",
                        dateRelease = "13 April 2019",
                        value_score = "Comedy, Romance, Action",
                        descript = "Lucy, seorang penyihir, bertemu Eclair, pendeta desa pemilik Batu Phoenix, yang harus ia lindungi. Saat si Carbuncle jahat mengejar mereka, Lucy dan teman-temannya harus mempertahankan Eclair.",
                        img_poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lV07a5UwE75jVVuFN1GFEscN7if.jpg",
                        preview_image = "https://image.tmdb.org/t/p/original/fANxNeH9JCXPrzNEfriGu1Y95dF.jpg"
                )
        )
        tvShows.add(
                ModelDataEntity(
                        id = 10,
                        name = "Fairy Tail",
                        dateRelease = "13 April 2019",
                        value_score = "Comedy, Romance, Action",
                        descript = "Lucy, seorang penyihir, bertemu Eclair, pendeta desa pemilik Batu Phoenix, yang harus ia lindungi. Saat si Carbuncle jahat mengejar mereka, Lucy dan teman-temannya harus mempertahankan Eclair.",
                        img_poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lV07a5UwE75jVVuFN1GFEscN7if.jpg",
                        preview_image = "https://image.tmdb.org/t/p/original/fANxNeH9JCXPrzNEfriGu1Y95dF.jpg"
                )
        )

        return tvShows
    }
}