$(document).ready(function () {

    var count, countOlx, countCarzz, countBestAuto, countAuto;
    var buttonAutovit = 1;
    var buttonOlx = 1;
    var buttonCarzz = 1;
    var buttonBestAuto = 1;
    var buttonAuto = 1;
    var price,city,title,img,link;

    // Customer-Form submit
    $(".form-inline.justify-content-center").submit(function (event) {
        // Prevent the form from submitting via the browser.
        event.preventDefault();

    });

    $('.btn.btn-red').click(function () {
        $('.imgLoader').append("<img src='https://ubisafe.org/images/transparent-background-loading.gif' style='display: block; margin: 0 auto;' id='loading_image'>");

        autovitPost();

    });



    var x = document.querySelector(".row.autovitElements");
    var y = document.querySelector(".row.olxElements");
    var z = document.querySelector(".row.carzzElements");
    var w = document.querySelector(".row.bestAutoElements");
    var a = document.querySelector(".row.autoElements");
    var b = document.querySelector(".col-12.recomandari");

// CREATE Recommendations

    function createRec(b, data) {
        b.insertAdjacentHTML("beforeend",

            "<div class='collapse-accordion' id='accordion' role='tablist' aria-multiselectable='true'>" +
                "<div class='card'>" +
                    "<div class='card-header mx-auto' role='tab' id='headingOne'>" +
                        "<h5 class='mb-0'>" +
                            "<a data-toggle='collapse' href='#collapseOne' aria-expanded='false' aria-controls='collapseOne'>Recomandari</a> " +
                        "</h5>" +
                    "</div>" +
                    "<div id='collapseOne' class='collapse' role='tabpanel' aria-labelledby='headingOne'>" +
                        "<div class='row'>" +
                            "<div class='col-2'>" +
                                "<div class='card' style='width:20rem'>" +
                                    "<a target='_blank' href=" + data.recommandationList[0].url + "><img class='card-img-top' src=" + data.recommandationList[0].img + "alt='Card image cap'></a>" +
                                        "<div class='card-body text-center'>" +
                                            "<p class='card-text text-center' style='color: black'>" + data.recommandationList[0].title + "</p>" +
                                                "<ul class='list-group list-group-flush'>" +
                                                    "<li class='list-group-item'>" +
                                                        "<div class='row'>" +
                                                            "<div class='col-md-6'>" +
                                                                "<i class='material-icons'>&#xe227;</i><span>" + data.recommandationList[0].price + "</span>" +
                                                            "</div>" +
                                                            "<div class='col-md-6'>" +
                                                                "<i class='material-icons'>&#xe0c8;</i><span>" + data.recommandationList[0].city + "</span>" +
                                                            "</div>" +
                                                        "</div>" +
                                                    "</li>" +
                                                 "</ul> " +
                                        "</div>" +
                                    "</div>" +
                                "</div>" +
                            "<div class='col-2'>" +
                                 "<div class='card' style='width:20rem; margin-left:50px;'>" +
                                    "<a target='_blank' href=" + data.recommandationList[1].url + "><img class='card-img-top' src=" + data.recommandationList[1].img + "alt='Card image cap'></a>" +
                                        "<div class='card-body text-center'>" +
                                            "<p class='card-text text-center' style='color: black'>" + data.recommandationList[1].title + "</p>" +
                                                 "<ul class='list-group list-group-flush'>" +
                                                    "<li class='list-group-item'>" +
                                                        "<div class='row'>" +
                                                            "<div class='col-md-6'>" +
                                                                "<i class='material-icons'>&#xe227;</i><span>" + data.recommandationList[1].price + "</span>" +
                                                            "</div>" +
                                                             "<div class='col-md-6'>" +
                                                                "<i class='material-icons'>&#xe0c8;</i><span>" + data.recommandationList[1].city + "</span>" +
                                                            "</div>" +
                                                        "</div>" +
                                                    "</li>" +
                                                "</ul> " +
                                        "</div>" +
                                "</div>" +
                            "</div>" +
                            "<div class='col-2'>" +
                                "<div class='card' style='width:20rem; margin-left:100px;'>" +
                                    "<a target='_blank' href=" + data.recommandationList[2].url + "><img class='card-img-top' src=" + data.recommandationList[2].img + " alt='Card image cap'></a>" +
                                        "<div class='card-body text-center'>" +
                                            "<p class='card-text text-center' style='color: black'>" + data.recommandationList[2].title + "</p>" +
                                                "<ul class='list-group list-group-flush'>" +
                                                    "<li class='list-group-item'>" +
                                                        "<div class='row'>" +
                                                            "<div class='col-md-6'>" +
                                                                "<i class='material-icons'>&#xe227;</i><span>" + data.recommandationList[2].price + "</span>" +
                                                            "</div>" +
                                                            "<div class='col-md-6'>" +
                                                                "<i class='material-icons'>&#xe0c8;</i><span>" + data.recommandationList[2].city + "</span>" +
                                                            "</div>" +
                                                        "</div>" +
                                                    "</li>" +
                                                "</ul> " +
                                        "</div>" +
                                "</div>" +
                            "</div>" +
                            "<div class='col-2'>" +
                                "<div class='card' style='width:20rem; margin-left:150px;'>" +
                                    "<a target='_blank' href=" + data.recommandationList[3].url + "><img class='card-img-top' src=" + data.recommandationList[3].img + " alt='Card image cap'></a>" +
                                        "<div class='card-body text-center'>" +
                                            "<p class='card-text text-center' style='color: black'>" + data.recommandationList[3].title + "</p>" +
                                                "<ul class='list-group list-group-flush'>" +
                                                    "<li class='list-group-item'>" +
                                                        "<div class='row'>" +
                                                            "<div class='col-md-6'>" +
                                                                "<i class='material-icons'>&#xe227;</i><span>" + data.recommandationList[3].price + "</span>" +
                                                            "</div>" +
                                                            "<div class='col-md-6'>" +
                                                                "<i class='material-icons'>&#xe0c8;</i><span>" + data.recommandationList[3].city + "</span>" +
                                                            "</div>" +
                                                        "</div>" +
                                                     "</li>" +
                                                "</ul> " +
                                        "</div>" +
                                "</div>" +
                            "</div>" +

                                "<div class='col-2'>" +
                                    "<div class='card' style='width:20rem; margin-left:200px;'>" +
                                        "<a target='_blank' href=" + data.recommandationList[3].url + "><img class='card-img-top' src=" + data.recommandationList[4].img + " alt='Card image cap'></a>" +
                                            "<div class='card-body text-center'>" +
                                                "<p class='card-text text-center' style='color: black'>" + data.recommandationList[4].title + "</p>" +
                                                    "<ul class='list-group list-group-flush'>" +
                                                        "<li class='list-group-item'>" +
                                                            "<div class='row'>" +
                                                                "<div class='col-md-6'>" +
                                                                    "<i class='material-icons'>&#xe227;</i><span>" + data.recommandationList[4].price + "</span>" +
                                                                "</div>" +
                                                                "<div class='col-md-6'>" +
                                                                    "<i class='material-icons'>&#xe0c8;</i><span>" + data.recommandationList[4].city + "</span>" +
                                                                "</div>" +
                                                            "</div>" +
                                                        "</li>" +
                                                    "</ul> " +
                                            "</div>" +
                                    "</div>" +
                                "</div>" +

                        "</div> " +
                    "</div>" +
                  "</div> "
        );
    }

//	CREATEA ADS

    function createAutovitAd2(x, i, data) {

        x.insertAdjacentHTML("beforeend",
            "<div class='col-sm-3 elementAutovit'>"
                    + "<div class='card' style='width:20rem;'>" +
                        "<a class='link-image' target='_blank' href=" + data.listaAutovit[i].url + "> <img class='card-img-top image' src=" + JSON.stringify(data.listaAutovit[i].img) + "alt='Card image cap'> </a>" +
                            "<div class='card-body text-center'>" +
                                "<p class='card-text text-center titleAd' style='color: black'>" + data.listaAutovit[i].title + "</p>" +
                                    "<ul class='list-group list-group-flush'>" +
                                        "<li class='list-group-item'>" +
                                            "<div class='row'>" +
                                                "<div class='col-md-6'>" +
                                                    "<i class='material-icons'>&#xe227;</i><span class='span-size price'>" + data.listaAutovit[i].pret + "</span>" +
                                                "</div>" +
                                                "<div class='col-md-6'>" +
                                                    "<i class='material-icons'>&#xe0c8;</i><span class='span-size city'>" + data.listaAutovit[i].oras + "</span>" +
                                                "</div>" +
                                            "</div>" +
                                        "</li>" +
                                    "</ul>" +
                                    "<button href=''#' class='btn btn-danger saveAd'>Save</button>" +
                            "</div>" +
                        "</div> " +
                    "</div> ");
    }

    function createAutovitAd3(x, i, data) {

        x.insertAdjacentHTML("beforeend",
            "<div class='col-sm-3 elementAutovit'>"
            + "<div class='card' style='width:20rem;'>" +
            "<a class='link-image' target='_blank' href=" + data.listaAutovit[i].url + "> <img class='card-img-top image' src=" + JSON.stringify(data.listaAutovit[i].img) + "alt='Card image cap'> </a>" +
            "<div class='card-body text-center'>" +
            "<p class='card-text text-center titleAd' style='color: black'>" + data.listaAutovit[i].title + "</p>" +
            "<ul class='list-group list-group-flush'>" +
            "<li class='list-group-item'>" +
            "<div class='row'>" +
            "<div class='col-md-6'>" +
            "<i class='material-icons'>&#xe227;</i><span class='span-size price'>" + data.listaAutovit[i].pret + "</span>" +
            "</div>" +
            "<div class='col-md-6'>" +
            "<i class='material-icons'>&#xe0c8;</i><span class='span-size city'>" + data.listaAutovit[i].oras + "</span>" +
            "</div>" +
            "</div>" +
            "</li>" +
            "</ul>" +
            "<button href=''#' class='btn btn-danger saveAdAutovit'>Save</button>" +
            "</div>" +
            "</div> " +
            "</div> ");
    }

    function createOlxAd(y, i, data) {
        y.insertAdjacentHTML("beforeend", "<div class='col-sm-3 elementOlx'>" + "<div class='card' style='width:20rem;'>" +
            "<a class='link-image' target='_blank' href=" + data.listaOlx[i].url + "><img class='card-img-top image' src=" + JSON.stringify(data.listaOlx[i].imgLink) + "alt='Card image cap'></a>" +
            "<div class='card-body text-center'>" +
            "<p class='card-text text-center titleAd' style='color: black'>" + data.listaOlx[i].title + "</p>" +
            "<ul class='list-group list-group-flush'>" +
            "<li class='list-group-item'>" +
            "<div class='row'>" +
            "<div class='col-md-6'>" +
            "<i class='material-icons'>&#xe227;</i><span class='span-size price'>" + data.listaOlx[i].price + "</span>" +
            "</div>" +
            "<div class='col-md-6'>" +
            "<i class='material-icons'>&#xe0c8;</i><span class='span-size city'>" + data.listaOlx[i].oras + "</span>" +
            "</div>" +
            "</div>" +
            "</li>" +
            "</ul>" +
            "<button href=''#' class='btn btn-danger saveAd'>Save</button>" +
            "</div>" +
            "</div> " +
            "</div> ")
    }

    function createOlxAd2(y, i, data) {
        y.insertAdjacentHTML("beforeend", "<div class='col-sm-3 elementOlx'>" + "<div class='card' style='width:20rem;'>" +
            "<a class='link-image' target='_blank' href=" + data.listaOlx[i].url + "><img class='card-img-top image' src=" + JSON.stringify(data.listaOlx[i].imgLink) + "alt='Card image cap'></a>" +
            "<div class='card-body text-center'>" +
            "<p class='card-text text-center titleAd' style='color: black'>" + data.listaOlx[i].title + "</p>" +
            "<ul class='list-group list-group-flush'>" +
            "<li class='list-group-item'>" +
            "<div class='row'>" +
            "<div class='col-md-6'>" +
            "<i class='material-icons'>&#xe227;</i><span class='span-size price'>" + data.listaOlx[i].price + "</span>" +
            "</div>" +
            "<div class='col-md-6'>" +
            "<i class='material-icons'>&#xe0c8;</i><span class='span-size city'>" + data.listaOlx[i].oras + "</span>" +
            "</div>" +
            "</div>" +
            "</li>" +
            "</ul>" +
            "<button href=''#' class='btn btn-danger saveAdOlx'>Save</button>" +
            "</div>" +
            "</div> " +
            "</div> ")
    }

    function createCarzzAd(z, i, data) {
        z.insertAdjacentHTML("beforeend", "<div class='col-sm-3 elementCarzz'>" + "<div class='card' style='width:20rem;'>" +
            "<a class='link-image' target='_blank' href=" + data.listaCarzz[i].url + " > <img class='card-img-top image' src=" + JSON.stringify(data.listaCarzz[i].img) + "alt='Card image cap'></a>" +
            "<div class='card-body text-center'>" +
            "<p class='card-text text-center titleAd' style='color: black'>" + data.listaCarzz[i].title + "</p>" +
            "<ul class='list-group list-group-flush'>" +
            "<li class='list-group-item'>" +
            "<div class='row'>" +
            "<div class='col-md-6'>" +
            "<i class='material-icons'>&#xe227;</i><span class='span-size price'>" + data.listaCarzz[i].price + "</span>" +
            "</div>" +
            "<div class='col-md-6'>" +
            "<i class='material-icons'>&#xe0c8;</i><span class='span-size city'>" + data.listaCarzz[i].oras + "</span>" +
            "</div>" +
            "</div>" +
            "</li>" +
            "</ul>" +
            "<button href=''#' class='btn btn-danger saveAd'>Save</button>" +
            "</div>" +
            "</div> " +
            "</div> ");
    }

    function createCarzzAd2(z, i, data) {
        z.insertAdjacentHTML("beforeend", "<div class='col-sm-3 elementCarzz'>" + "<div class='card' style='width:20rem;'>" +
            "<a class='link-image' target='_blank' href=" + data.listaCarzz[i].url + " > <img class='card-img-top image' src=" + JSON.stringify(data.listaCarzz[i].img) + "alt='Card image cap'></a>" +
            "<div class='card-body text-center'>" +
            "<p class='card-text text-center titleAd' style='color: black'>" + data.listaCarzz[i].title + "</p>" +
            "<ul class='list-group list-group-flush'>" +
            "<li class='list-group-item'>" +
            "<div class='row'>" +
            "<div class='col-md-6'>" +
            "<i class='material-icons'>&#xe227;</i><span class='span-size price'>" + data.listaCarzz[i].price + "</span>" +
            "</div>" +
            "<div class='col-md-6'>" +
            "<i class='material-icons'>&#xe0c8;</i><span class='span-size city'>" + data.listaCarzz[i].oras + "</span>" +
            "</div>" +
            "</div>" +
            "</li>" +
            "</ul>" +
            "<button href=''#' class='btn btn-danger saveAdCarzz'>Save</button>" +
            "</div>" +
            "</div> " +
            "</div> ");
    }

    function createBestAutoAd(w, i, data) {
        w.insertAdjacentHTML("beforeend", "<div class='col-sm-3 elementBestAuto'>" + "<div class='card' style='width:20rem;'>" +
            "<a class='link-image' target='_blank' href=" + data.listaBestAuto[i].url + " > <img class='card-img-top image' src=" + JSON.stringify(data.listaBestAuto[i].img) + "alt='Card image cap'></a>" +
            "<div class='card-body text-center'>" +
            "<p class='card-text text-center titleAd' style='color: black'>" + data.listaBestAuto[i].title + "</p>" +
            "<ul class='list-group list-group-flush'>" +
            "<li class='list-group-item'>" +
            "<div class='row'>" +
            "<div class='col-md-6'>" +
            "<i class='material-icons'>&#xe227;</i><span class='span-size price'>" + data.listaBestAuto[i].price + "</span>" +
            "</div>" +
            "<div class='col-md-6'>" +
            "<i class='material-icons'>&#xe0c8;</i><span class='span-size city'>" + data.listaBestAuto[i].city + "</span>" +
            "</div>" +
            "</div>" +
            "</li>" +
            "</ul>" +
            "<button href=''#' class='btn btn-danger saveAd'>Save</button>" +
            "</div>" +
            "</div> " +
            "</div> ");
    }

    function createBestAutoAd2(w, i, data) {
        w.insertAdjacentHTML("beforeend", "<div class='col-sm-3 elementBestAuto'>" + "<div class='card' style='width:20rem;'>" +
            "<a class='link-image' target='_blank' href=" + data.listaBestAuto[i].url + " > <img class='card-img-top image' src=" + JSON.stringify(data.listaBestAuto[i].img) + "alt='Card image cap'></a>" +
            "<div class='card-body text-center'>" +
            "<p class='card-text text-center titleAd' style='color: black'>" + data.listaBestAuto[i].title + "</p>" +
            "<ul class='list-group list-group-flush'>" +
            "<li class='list-group-item'>" +
            "<div class='row'>" +
            "<div class='col-md-6'>" +
            "<i class='material-icons'>&#xe227;</i><span class='span-size price'>" + data.listaBestAuto[i].price + "</span>" +
            "</div>" +
            "<div class='col-md-6'>" +
            "<i class='material-icons'>&#xe0c8;</i><span class='span-size city'>" + data.listaBestAuto[i].city + "</span>" +
            "</div>" +
            "</div>" +
            "</li>" +
            "</ul>" +
            "<button href=''#' class='btn btn-danger saveAdBestAuto'>Save</button>" +
            "</div>" +
            "</div> " +
            "</div> ");
    }

    function createAutoAd(w, i, data) {
        a.insertAdjacentHTML("beforeend", "<div class='col-sm-3 elementAuto'>" + "<div class='card' style='width:20rem;'>" +
            "<a class='link-image' target='_blank' href=" + data.listaAuto[i].url + " > <img class='card-img-top image' src=" + JSON.stringify(data.listaAuto[i].img) + "alt='Card image cap'></a>" +
            "<div class='card-body text-center'>" +
            "<p class='card-text text-center titleAd' style='color: black'>" + data.listaAuto[i].title + "</p>" +
            "<ul class='list-group list-group-flush'>" +
            "<li class='list-group-item'>" +
            "<div class='row'>" +
            "<div class='col-md-6'>" +
            "<i class='material-icons'>&#xe227;</i><span class='span-size price'>" + data.listaAuto[i].price + "</span>" +
            "</div>" +
            "<div class='col-md-6'>" +
            "<i class='material-icons'>&#xe0c8;</i><span class='span-size city'>" + data.listaAuto[i].oras + "</span>" +
            "</div>" +
            "</div>" +
            "</li>" +
            "</ul>" +
            "<button href=''#' class='btn btn-danger saveAd'>Save</button>" +
            "</div>" +
            "</div> " +
            "</div> ");
    }

    function createAutoAd2(w, i, data) {
        a.insertAdjacentHTML("beforeend", "<div class='col-sm-3 elementAuto'>" + "<div class='card' style='width:20rem;'>" +
            "<a class='link-image' target='_blank' href=" + data.listaAuto[i].url + " > <img class='card-img-top image' src=" + JSON.stringify(data.listaAuto[i].img) + "alt='Card image cap'></a>" +
            "<div class='card-body text-center'>" +
            "<p class='card-text text-center titleAd' style='color: black'>" + data.listaAuto[i].title + "</p>" +
            "<ul class='list-group list-group-flush'>" +
            "<li class='list-group-item'>" +
            "<div class='row'>" +
            "<div class='col-md-6'>" +
            "<i class='material-icons'>&#xe227;</i><span class='span-size price'>" + data.listaAuto[i].price + "</span>" +
            "</div>" +
            "<div class='col-md-6'>" +
            "<i class='material-icons'>&#xe0c8;</i><span class='span-size city'>" + data.listaAuto[i].oras + "</span>" +
            "</div>" +
            "</div>" +
            "</li>" +
            "</ul>" +
            "<button href=''#' class='btn btn-danger saveAdAuto'>Save</button>" +
            "</div>" +
            "</div> " +
            "</div> ");
    }

    function saveAd(price,city,title,img,link){

        $.ajax({
            type: "POST",

            url: "/saveAd",
            data: {
                'price': price,
                'city': city,
                'title': title,
                'img': img,
                'link': link,
            },
            success: function (data) {
                alert(data);
            },
            error: function (e) {
                alert("Error!")
                console.log("ERROR: ", e);
            }
        });
    }

    function autovitPost() {
        $('.btn.btn-red').attr("disabled", true);
        // DO POST
// var token = $("meta[name='_csrf']").attr("content");
// var header = $("meta[name='_csrf_header']").attr("content");
        // beforeSend: function (xhr) {
        // xhr.setRequestHeader(header, token);
        // },
        // url : "/search?_csrf='+csrfCookie'",

        $.ajax({
            type: "POST",

            url: "/search",
            dataType: "json",
            data: {
                'marcaId': $('#marcaId').val(),
                'modelId': $('#modelId').val(),
                'pretDeLa': $('#pretDeLa').val(),
                'pretPanaLa': $('#pretPanaLa').val(),
                'anFabrDeLa': $('#anFabrDeLa').val(),
                'anFabrPanaLa': $('#anFabrPanaLa').val(),
                'orasParam': $('#orasParam').val()
            },
            success: function (data) {
                $('.btn.btn-red').attr("disabled", false);
                console.log(data.adsNumberAutovit);
                count = 2;
                countOlx = 2;
                countCarzz = 2;
                countBestAuto = 2;
                countAuto = 2;

                $('#loading_image').remove();
                console.log(data);
                // AUTOVIT
                $('.autovitResults .autovit').remove();
                $('.row.autovitElements .elementAutovit').remove();
                $('.paginare .pagination').remove();
                $('.row.autovitElements .noResultsAutovit').remove();
                $('.collapse-accordion').remove();

                // recomandare
                if (data.recommandationList.length !== 0) {
                    createRec(b, data);
                }

                $('.autovitResults').append('<h2 class="autovit" style="display:inline-block">Rezultate Autovit: </h2>');
                if (data.listaAutovit.length !== null) {
                    if (data.adsNumberAutovit > 1) {
                        buttonAutovit = 1;
                        $('.autovit').append("<p class='buttonAutovitSearch1' style='display:inline-block'>" + buttonAutovit + "/" + data.adsNumberAutovit + "</p>");
                        $('.autovit').append("<button href='#' style='margin-left:650px;margin-bottom:10px'; class='btn btn-danger anunturiAutovit'>Next Page</button>");
                    }

                    for (var i = 0; i < data.listaAutovit.length; i++) {
                        createAutovitAd2(x, i, data);
                    }
                } else {
                    console.log("probleme");
                }


                $('.paginare').append(
                    "<nav style='margin-top:5px;'>" +
                    "<ul class='pagination justify-content-center pagination-sm autovit'>" +
                    "</ul>" +
                    "</nav>"
                );

                if (data.listaAutovit.length === 0) {
                    $('.row.autovitElements').append("<h2 class='noResultsAutovit'>Nu au fost gasite rezultate pe Autovit!</h2>");
                    $('.autovitResults .autovit').remove();
                    $('.pagination.justify-content-center.pagination-sm.autovit').remove();
                }

                // PAGINARE AUTOVIT
                paginareAutovit();

                $('.btn.btn-danger.anunturiAutovit').on('click', function () {
                    console.log("S-a apasat pe buton!");
                    buttonAutovit++;
                    if (buttonAutovit > data.adsNumberAutovit) {
                        buttonAutovit = 1;
                    }
                    $('.buttonAutovitSearch1').text(buttonAutovit + '/' + data.adsNumberAutovit);
                    multipleSearches();
                });


//					OLX OLX OLX
                $('#loading_image').remove();
                console.log("OLX ANUNTURI:" + data);
                // OLX
                $('.olxResults .olx').remove();
                $('.row.olxElements .elementOlx').remove();
                $('.paginareOlx .paginationOlx').remove();
                $('.row.olxElements .noResultsOlx').remove();

                $('.olxResults').append('<h2 class="olx" style="display:inline-block">Rezultate Olx: </h2>');
                if (data.listaOlx.length !== null) {
                    if (data.adsNumberOlx > 1) {
                        buttonOlx = 1;
                        $('.olx').append("<p class='buttonOlxSearch1' style='display:inline-block'>" + buttonOlx + "/" + data.adsNumberOlx + "</p>");
                        $('.olx').append("<button href='#' style='margin-left:650px;margin-bottom:10px'; class='btn btn-danger anunturiOlx'>Next Page</button>");
                    }
                    for (var i = 0; i < data.listaOlx.length; i++) {
                        createOlxAd(y, i, data);
                    }
                } else {
                    console.log("probleme");
                }

                $('.paginareOlx').append(
                    "<nav style='margin-top:5px;'>" +
                    "<ul class='pagination paginationOlx justify-content-center pagination-sm olxAdsPagination'>" +
                    "</ul>" +
                    "</nav>"
                );

                if (data.listaOlx.length === 0) {
                    $('.row.olxElements').append("<h2 class='noResultsOlx'>Nu au fost gasite rezultate pe Olx!</h2>");
                    $('.olxResults .olx').remove();
                    $('.pagination.paginationOlx.justify-content-center.pagination-sm.olxAdsPagination').remove();
                }

                paginareOlx();

                $('.btn.btn-danger.anunturiOlx').on('click', function () {
                    console.log("S-a apasat pe buton Olx!");
                    buttonOlx++;
                    if (buttonOlx > data.adsNumberOlx) {
                        buttonOlx = 1;
                    }
                    $('.buttonOlxSearch1').text(buttonOlx + '/' + data.adsNumberOlx);
                    multipleSearchesOlx();
                });

//					CARZZ CARZZ CARZZ CARZZ

                console.log("Carzz ANUNTURI:" + data.listaCarzz);
                // Publi24
                $('.carzzResults .carzz').remove();
                $('.row.carzzElements .elementCarzz').remove();
                $('.paginareCarzz .paginationCarzz').remove();
                $('.row.carzzElements .noResultsCarzz').remove();

                $('.carzzResults').append('<h2 class="carzz" style="display:inline-block">Rezultate Carzz: </h2>');
                if (data.listaCarzz.length !== null || data.listaCarzz.length !== 0) {


                    if (data.adsNumberCarzz > 1) {
                        buttonCarzz = 1;
                        $('.carzz').append("<p class='buttonCarzzSearch1' style='display:inline-block'>" + buttonCarzz + "/" + data.adsNumberCarzz + "</p>");
                        $('.carzz').append("<button href='#' style='margin-left:650px;margin-bottom:10px'; class='btn btn-danger anunturiCarzz'>Next Page</button>");
                    }

                    for (var i = 0; i < data.listaCarzz.length; i++) {
                        createCarzzAd(z, i, data);
                    }
                } else {
                    console.log("probleme");
                }


                $('.paginareCarzz').append(
                    "<nav style='margin-top:5px;'>" +
                    "<ul class='pagination paginationCarzz justify-content-center pagination-sm carzzAdsPagination'>" +
                    "</ul>" +
                    "</nav>"
                );

                paginareCarzz();

                if (data.listaCarzz.length === 0) {
                    $('.row.carzzElements').append("<h2 class='noResultsCarzz'>Nu au fost gasite rezultate pe Carzz!</h2>");
                    $('.carzzResults .carzz').remove();
                    $('.paginationCarzz').remove();
                }


                $('.btn.btn-danger.anunturiCarzz').on('click', function () {
                    console.log("S-a apasat pe buton Publi24!");

                    buttonCarzz++;
                    if (buttonCarzz > data.adsNumberCarzz) {
                        buttonCarzz = 1;
                    }

                    $('.buttonCarzzSearch1').text(buttonCarzz + '/' + data.adsNumberCarzz);
                    multipleSearchesCarzz();
                });

//					BESTAUTO BESTAUTO BESTAUTO BEST AUTO

                console.log("BestAuto ANUNTURI:" + data.adsNumberBestAuto[0]);


                // BESTAUTO
                $('.bestAutoResults .bestauto').remove();
                $('.row.bestAutoElements .elementBestAuto').remove();
                $('.paginareBestAuto .paginationBestAuto').remove();
                $('.row.bestAutoElements .noResultsBestAuto').remove();

                $('.bestAutoResults').append('<h2 class="bestauto" style="display:inline-block">Rezultate BestAuto: </h2>');
                if (data.listaBestAuto.length !== null) {
                    if (data.adsNumberBestAuto > 1) {

                        buttonBestAuto = 1;
                        $('.bestauto').append("<p class='buttonBestAutoSearch1' style='display:inline-block'>" + buttonBestAuto + "/" + data.adsNumberBestAuto + "</p>");
                        $('.bestauto').append("<button href='#' style='margin-left:650px;margin-bottom:10px'; class='btn btn-danger anunturiBestAuto'>Next Page</button>");
                    }

                    for (var i = 0; i < data.listaBestAuto.length; i++) {
                        createBestAutoAd(w, i, data);
                    }
                } else {
                    console.log("probleme");
                }


                $('.paginareBestAuto').append(
                    "<nav style='margin-top:5px;'>" +
                    "<ul class='pagination paginationBestAuto justify-content-center pagination-sm bestautoAdsPagination'>" +
                    "</ul>" +
                    "</nav>"
                );

                paginareBestAuto();

                if (data.listaBestAuto.length === 0) {
                    $('.row.bestAutoElements').append("<h2 class='noResultsBestAuto'>Nu au fost gasite rezultate pe BestAuto!</h2>");
                    $('.bestAutoResults .bestauto').remove();
                    $('.paginationBestAuto').remove();
                }

                $('.btn.btn-danger.anunturiBestAuto').on('click', function () {
                    console.log("S-a apasat pe buton BestAuto!");
                    buttonBestAuto++;
                    if (buttonBestAuto > data.adsNumberBestAuto) {
                        buttonBestAuto = 1;
                    }
                    $('.buttonBestAutoSearch1').text(buttonBestAuto + '/' + data.adsNumberBestAuto);
                    multipleSearchesBestAuto();
                });


//					AUTO AUTO AUTO AUTO 

                $('.autoResults .auto').remove();
                $('.row.autoElements .elementAuto').remove();
                $('.paginareAuto .paginationAuto').remove();
                $('.row.autoElements .noResultsAuto').remove();

                $('.autoResults').append('<h2 class="auto" style="display:inline-block">Rezultate Auto: </h2>');
                if (data.listaAuto.length !== null) {
                    if(data.adsNumberAuto > 1){
                        buttonAuto = 1;
                        $('.auto').append("<p class='buttonAutoSearch1' style='display:inline-block'>" + buttonAuto + "/" + data.adsNumberAuto + "</p>");
                        $('.auto').append("<button href='#' style='margin-left:650px;margin-bottom:10px'; class='btn btn-danger anunturiAuto'>Next Page</button>");

                    }
                    for (var i = 0; i < data.listaAuto.length; i++) {
                        createAutoAd(w, i, data);
                    }
                } else {
                    console.log("probleme");
                }


                $('.paginareAuto').append(
                    "<nav style='margin-top:5px;'>" +
                    "<ul class='pagination paginationAuto justify-content-center pagination-sm autoAdsPagination'>" +
                    "</ul>" +
                    "</nav>"
                );

                paginareAuto();

                if (data.listaAuto.length === 0) {
                    $('.row.autoElements').append("<h2 class='noResultsAuto'>Nu au fost gasite rezultate pe Auto!</h2>");
                    $('.autoResults .auto').remove();
                    $('.paginationAuto').remove();
                }

                $('.btn.btn-danger.anunturiAuto').on('click', function () {
                    console.log("S-a apasat pe buton Auto!");
                    buttonAuto++;
                    if (buttonAuto > data.adsNumberAuto) {
                        buttonAuto = 1;
                    }
                    $('.buttonAutoSearch1').text(buttonAuto + '/' + data.adsNumberAuto);
                    multipleSearchesAuto();
                });

                $('.btn.btn-danger.saveAd').on('click', function () {
                    console.log("S-a apasat pe buton!");
                     price = $(this).closest('.card').find('.price').text();
                     city = $(this).closest('.card').find('.city').text();
                     title = $(this).closest('.card').find('.titleAd').text();
                     img = $(this).closest('.card').find('.image').attr('src');
                     link = $(this).closest('.card').find('.link-image').attr('href');

                    saveAd(price,city,title,img,link);
                    console.log('S-a apelat din principal');
                });


            },
            error: function (e) {
                alert("Error!")
                console.log("ERROR: ", e);
            }
        });
    }

    function multipleSearches() {
        // DO POST
        $('.btn.btn-danger.anunturiAutovit').attr("disabled", true);
        $.ajax({
            type: "POST",
            url: "/searchAutovit",
            dataType: "json",
            data: {
                'marcaId': $('#marcaId').val(),
                'modelId': $('#modelId').val(),
                'pretDeLa': $('#pretDeLa').val(),
                'pretPanaLa': $('#pretPanaLa').val(),
                'anFabrDeLa': $('#anFabrDeLa').val(),
                'anFabrPanaLa': $('#anFabrPanaLa').val(),
                'orasParam': $('#orasParam').val(),
                'count': count
            },
            success: function (data) {
                $('.btn.btn-danger.anunturiAutovit').attr("disabled", false);
                $('#loading_image').remove();
                console.log("VALOARE COUNT:" + count);
                // AUTOVIT
                /* $('.autovitResults .autovit').remove(); */
                $('.row.autovitElements .elementAutovit').remove();
                $('.paginare .pagination').remove();
                $('.row.autovitElements .noResultsAutovit').remove();
                if (data.listaAutovit.length !== null) {
                    /*
                     * $('.autovit').append("<button href='#'
                     * style='margin-left:800px'; class='btn btn-danger
                     * anunturiAutovit'>Next Ads</button>");
                     */
                    for (var i = 0; i < data.listaAutovit.length; i++) {
                        createAutovitAd3(x, i, data);
                    }
                } else {
                    console.log("probleme");
                }

                if (data.listaAutovit.length === 0) {
                    $('.row.autovitElements').append("<h2 class='noResultsAutovit'>Nu au fost gasite rezultate pe Autovit!</h2>");
                    $('.autovitResults .autovit').remove();
                }
                $('.paginare').append(
                    "<nav style='margin-top:5px;'>" +
                    "<ul class='pagination justify-content-center pagination-sm autovit'>" +
                    "</ul>" +
                    "</nav>"
                );

                // PAGINARE AUTOVIT
                paginareAutovit();
                console.log("Numar pagini pe autovit met2: " + data.adsNumberAutovitPage);
                count++;
                if (count > data.adsNumberAutovitPage) {
                    count = 1;
                }

                $('.btn.btn-danger.saveAdAutovit').on('click', function () {
                    console.log("S-a apasat pe buton!");
                     price = $(this).closest('.card').find('.price').text();
                     city = $(this).closest('.card').find('.city').text();
                     title = $(this).closest('.card').find('.titleAd').text();
                     img = $(this).closest('.card').find('.image').attr('src');
                     link = $(this).closest('.card').find('.link-image').attr('href');

                    saveAd(price,city,title,img,link);
                    console.log('S-a apelat din autovit');
                });

            },
            error: function (e) {
                alert("Error!")
                console.log("ERROR: ", e);
            }
        });
    }

    function multipleSearchesOlx() {
        // DO POST
        $('.btn.btn-danger.anunturiOlx').attr("disabled", true);
        $.ajax({
            type: "POST",
            url: "/searchOlx",
            dataType: "json",
            data: {
                'marcaId': $('#marcaId').val(),
                'modelId': $('#modelId').val(),
                'pretDeLa': $('#pretDeLa').val(),
                'pretPanaLa': $('#pretPanaLa').val(),
                'anFabrDeLa': $('#anFabrDeLa').val(),
                'anFabrPanaLa': $('#anFabrPanaLa').val(),
                'orasParam': $('#orasParam').val(),
                'count': countOlx
            },
            success: function (data) {
                $('.btn.btn-danger.anunturiOlx').attr("disabled", false);
                $('#loading_image').remove();
                console.log(data);
                // AUTOVIT
                /* $('.autovitResults .autovit').remove(); */
                $('.row.olxElements .elementOlx').remove();
                $('.paginareOlx .pagination').remove();
                $('.row.olxElements .noResultsOlx').remove();
                if (data.listaOlx.length !== null) {
                    /*
                     * $('.autovit').append("<button href='#'
                     * style='margin-left:800px'; class='btn btn-danger
                     * anunturiAutovit'>Next Ads</button>");
                     */
                    for (var i = 0; i < data.listaOlx.length; i++) {
                        createOlxAd2(y, i, data);
                    }
                } else {
                    console.log("probleme");
                }

                if (data.listaOlx.length === 0) {
                    $('.row.olxElements').append("<h2 class='noResultsOlx'>Nu au fost gasite rezultate pe Olx!</h2>");
                    $('.olxResults .olx').remove();
                }
                $('.paginareOlx').append(
                    "<nav style='margin-top:5px;'>" +
                    "<ul class='pagination paginationOlx justify-content-center pagination-sm olxAdsPagination'>" +
                    "</ul>" +
                    "</nav>"
                );

                // PAGINARE OLX
                paginareOlx();

                countOlx++;
                if (countOlx > data.adsNumberOlx) {
                    countOlx = 1;
                }

                $('.btn.btn-danger.saveAdOlx').on('click', function () {
                    console.log("S-a apasat pe buton!");
                     price = $(this).closest('.card').find('.price').text();
                     city = $(this).closest('.card').find('.city').text();
                     title = $(this).closest('.card').find('.titleAd').text();
                     img = $(this).closest('.card').find('.image').attr('src');
                     link = $(this).closest('.card').find('.link-image').attr('href');

                     saveAd(price,city,title,img,link);
                    console.log('S-a apelat din olx');
                });

            },
            error: function (e) {
                alert("Error!")
                console.log("ERROR: ", e);
            }
        });
    }


    function multipleSearchesCarzz() {
        // DO POST

        $.ajax({
            type: "POST",
            url: "/searchCarzz",
            dataType: "json",
            data: {
                'marcaId': $('#marcaId').val(),
                'modelId': $('#modelId').val(),
                'pretDeLa': $('#pretDeLa').val(),
                'pretPanaLa': $('#pretPanaLa').val(),
                'anFabrDeLa': $('#anFabrDeLa').val(),
                'anFabrPanaLa': $('#anFabrPanaLa').val(),
                'orasParam': $('#orasParam').val(),
                'count': countCarzz
            },
            success: function (data) {
                $('#loading_image').remove();
                console.log(data);
                // AUTOVIT
                /* $('.autovitResults .autovit').remove(); */
                $('.row.carzzElements .elementCarzz').remove();
                $('.paginareCarzz .paginationCarzz').remove();
                $('.row.carzzElements .noResultsCarzz').remove();
                console.log("VALOARE butoncarzz: " + buttonCarzz);
                if (data.listaCarzz.length !== null) {
                    /*
                     * $('.autovit').append("<button href='#'
                     * style='margin-left:800px'; class='btn btn-danger
                     * anunturiAutovit'>Next Ads</button>");
                     */
                    for (var i = 0; i < data.listaCarzz.length; i++) {
                        createCarzzAd2(z, i, data);

                    }
                } else {
                    console.log("probleme");
                }

                if (data.listaCarzz.length === 0) {
                    $('.row.carzzElements').append("<h2 class='noResultsCarzz'>Nu au fost gasite rezultate pe Carzz!</h2>");
                    $('.carzzResults .carzz').remove();
                }
                $('.paginareCarzz').append(
                    "<nav style='margin-top:5px;'>" +
                    "<ul class='pagination paginationCarzz justify-content-center pagination-sm carzzAdsPagination'>" +
                    "</ul>" +
                    "</nav>"
                );

                paginareCarzz();

                countCarzz++;
                if (countCarzz > data.adsNumberCarzz) {
                    countCarzz = 1;
                }

                $('.btn.btn-danger.saveAdCarzz').on('click', function () {
                    console.log("S-a apasat pe buton!");
                     price = $(this).closest('.card').find('.price').text();
                     city = $(this).closest('.card').find('.city').text();
                     title = $(this).closest('.card').find('.titleAd').text();
                     img = $(this).closest('.card').find('.image').attr('src');
                     link = $(this).closest('.card').find('.link-image').attr('href');

                     saveAd(price,city,title,img,link);
                    console.log('S-a apelat din carzz');
                });

            },
            error: function (e) {
                alert("Error!")
                console.log("ERROR: ", e);
            }
        });
    }

    function multipleSearchesBestAuto() {
        // DO POST

        $.ajax({
            type: "POST",
            url: "/searchBestAuto",
            dataType: "json",
            data: {
                'marcaId': $('#marcaId').val(),
                'modelId': $('#modelId').val(),
                'pretDeLa': $('#pretDeLa').val(),
                'pretPanaLa': $('#pretPanaLa').val(),
                'anFabrDeLa': $('#anFabrDeLa').val(),
                'anFabrPanaLa': $('#anFabrPanaLa').val(),
                'orasParam': $('#orasParam').val(),
                'count': countBestAuto
            },
            success: function (data) {
                $('#loading_image').remove();
                // BESTAUTO
                /* $('.autovitResults .autovit').remove(); */
                $('.row.bestAutoElements .elementBestAuto').remove();
                $('.paginareBestAuto .paginationBestAuto').remove();
                $('.row.bestAutoElements .noResultsBestAuto').remove();
                if (data.length !== null) {
                    /*
                     * $('.autovit').append("<button href='#'
                     * style='margin-left:800px'; class='btn btn-danger
                     * anunturiAutovit'>Next Ads</button>");
                     */
                    for (var i = 0; i < data.listaBestAuto.length; i++) {
                        createBestAutoAd2(w, i, data);
                    }
                } else {
                    console.log("probleme");
                }

                if (data.length === 0) {
                    $('.row.bestAutoElements').append("<h2 class='noResultsBestAuto'>Nu au fost gasite rezultate pe BestAuto!</h2>");
                    $('.bestAutoResults .bestAuto').remove();
                }
                $('.paginareBestAuto').append(
                    "<nav style='margin-top:5px;'>" +
                    "<ul class='pagination paginationBestAuto justify-content-center pagination-sm bestautoAdsPagination'>" +
                    "</ul>" +
                    "</nav>"
                );

                paginareBestAuto();

                countBestAuto++;
                if (countBestAuto > data.adsNumberBestAuto) {
                    countBestAuto = 1;
                }

                $('.btn.btn-danger.saveAdBestAuto').on('click', function () {
                    console.log("S-a apasat pe buton!");
                     price = $(this).closest('.card').find('.price').text();
                     city = $(this).closest('.card').find('.city').text();
                     title = $(this).closest('.card').find('.titleAd').text();
                     img = $(this).closest('.card').find('.image').attr('src');
                     link = $(this).closest('.card').find('.link-image').attr('href');

                    saveAd(price,city,title,img,link);
                    console.log('S-a apelat din bestauto');
                });

            },
            error: function (e) {
                alert("Error!")
                console.log("ERROR: ", e);
            }
        });
    }

    function multipleSearchesAuto() {
        // DO POST

        $.ajax({
            type: "POST",
            url: "/searchAuto",
            dataType: "json",
            data: {
                'marcaId': $('#marcaId').val(),
                'modelId': $('#modelId').val(),
                'pretDeLa': $('#pretDeLa').val(),
                'pretPanaLa': $('#pretPanaLa').val(),
                'anFabrDeLa': $('#anFabrDeLa').val(),
                'anFabrPanaLa': $('#anFabrPanaLa').val(),
                'orasParam': $('#orasParam').val(),
                'count': countAuto
            },
            success: function (data) {
                $('#loading_image').remove();
                // BESTAUTO
                /* $('.autovitResults .autovit').remove(); */
                $('.row.autoElements .elementAuto').remove();
                $('.paginareAuto .paginationAuto').remove();
                $('.row.autoElements .noResultsAuto').remove();
                if (data.listaAuto.length > 0) {

                    for (var i = 0; i < data.listaAuto.length; i++) {
                        createAutoAd2(w, i, data);
                    }
                } else {
                    console.log("probleme");
                }

                if (data.length === 0) {
                    $('.row.autoElements').append("<h2 class='noResultsAuto'>Nu au fost gasite rezultate pe Auto!</h2>");
                    $('.autoResults .auto').remove();
                }
                $('.paginareAuto').append(
                    "<nav style='margin-top:5px;'>" +
                    "<ul class='pagination paginationAuto justify-content-center pagination-sm autoAdsPagination'>" +
                    "</ul>" +
                    "</nav>"
                );

                paginareAuto();

                countAuto++;
                if (countAuto > data.adsNumberAuto) {
                    countAuto = 1;
                }

                $('.btn.btn-danger.saveAdAuto').on('click', function () {
                    console.log("S-a apasat pe buton!");
                     price = $(this).closest('.card').find('.price').text();
                     city = $(this).closest('.card').find('.city').text();
                     title = $(this).closest('.card').find('.titleAd').text();
                     img = $(this).closest('.card').find('.image').attr('src');
                     link = $(this).closest('.card').find('.link-image').attr('href');

                     saveAd(price,city,title,img,link);
                    console.log('S-a apelat din auto');
                });

            },
            error: function (e) {
                alert("Error!")
                console.log("ERROR: ", e);
            }
        });
    }


    function paginareAutovit() {
        function getPageList(totalPages, page, maxLength) {
            if (maxLength < 5) throw "maxLength must be at least 5";

            function range(start, end) {
                return Array.from(Array(end - start + 1), (_, i) => i + start);
            }

            var sideWidth = maxLength < 9 ? 1 : 2;
            var leftWidth = (maxLength - sideWidth * 2 - 3) >> 1;
            var rightWidth = (maxLength - sideWidth * 2 - 2) >> 1;
            if (totalPages <= maxLength) {
                // no breaks in list
                return range(1, totalPages);
            }
            if (page <= maxLength - sideWidth - 1 - rightWidth) {
                // no break on left of page
                return range(1, maxLength - sideWidth - 1)
                    .concat([0])
                    .concat(range(totalPages - sideWidth + 1, totalPages));
            }
            if (page >= totalPages - sideWidth - 1 - rightWidth) {
                // no break on right of page
                return range(1, sideWidth)
                    .concat([0])
                    .concat(
                        range(totalPages - sideWidth - 1 - rightWidth - leftWidth, totalPages)
                    );
            }
            // Breaks on both sides
            return range(1, sideWidth)
                .concat([0])
                .concat(range(page - leftWidth, page + rightWidth))
                .concat([0])
                .concat(range(totalPages - sideWidth + 1, totalPages));
        }

        $(function () {
            // Number of items and limits the number of items per page
            var numberOfItems = $(".row.autovitElements .elementAutovit").length;
            /* console.log(numberOfItems) */
            var limitPerPage = 4;
            // Total pages rounded upwards
            var totalPages = Math.ceil(numberOfItems / limitPerPage);
            // Number of buttons at the top, not counting prev/next,
            // but including the dotted buttons.
            // Must be at least 5:
            var paginationSize = 7;
            var currentPage;

            function showPage(whichPage) {
                /* console.log(whichPage); */
                if (whichPage < 1 || whichPage > totalPages) return false;
                currentPage = whichPage;
                $(".row.autovitElements .elementAutovit")
                    .hide()
                    .slice((currentPage - 1) * limitPerPage, currentPage * limitPerPage)
                    .show();
                // Replace the navigation items (not prev/next):
                $(".pagination.autovit li").slice(1, -1).remove();
                getPageList(totalPages, currentPage, paginationSize).forEach(item => {
                    $("<li>")
                    .addClass(
                        "page-item " +
                        (item ? "current-page " : "") +
                        (item === currentPage ? "active " : "")
                    )
                    .append(
                        $("<a>")
                            .addClass("page-link")
                            .attr({
                                href: "javascript:void(0)"
                            })
                            .text(item || "...")
                    )
                    .insertBefore("#next-page");
            });
                return true;
            }

            // Include the prev/next buttons:
            $(".pagination.autovit ").append(
                $("<li>").addClass("page-item").attr({id: "previous-page"}).append(
                    $("<a>")
                        .addClass("page-link")
                        .attr({
                            href: "javascript:void(0)"
                        })
                        .text("Prev")
                ),
                $("<li>").addClass("page-item").attr({id: "next-page"}).append(
                    $("<a>")
                        .addClass("page-link")
                        .attr({
                            href: "javascript:void(0)"
                        })
                        .text("Next")
                )
            );
            // Show the page links
            $(".row.autovitElements").show();
            showPage(1);

            // Use event delegation, as these items are recreated later
            $(
                document
            ).on("click", ".pagination li.current-page:not(.active)", function (e) {
                e.preventDefault();
                return showPage(+$(this).text());
            });
            $("#next-page").on("click", function (e) {
                e.preventDefault();
                return showPage(currentPage + 1);
            });

            $("#previous-page").on("click", function (e) {
                e.preventDefault();
                return showPage(currentPage - 1);
            });
        });
    }


    function paginareOlx() {
        function getPageList(totalPages, page, maxLength) {
            if (maxLength < 5) throw "maxLength must be at least 5";

            function range(start, end) {
                return Array.from(Array(end - start + 1), (_, i) => i + start);
            }

            var sideWidth = maxLength < 9 ? 1 : 2;
            var leftWidth = (maxLength - sideWidth * 2 - 3) >> 1;
            var rightWidth = (maxLength - sideWidth * 2 - 2) >> 1;
            if (totalPages <= maxLength) {
                // no breaks in list
                return range(1, totalPages);
            }
            if (page <= maxLength - sideWidth - 1 - rightWidth) {
                // no break on left of page
                return range(1, maxLength - sideWidth - 1)
                    .concat([0])
                    .concat(range(totalPages - sideWidth + 1, totalPages));
            }
            if (page >= totalPages - sideWidth - 1 - rightWidth) {
                // no break on right of page
                return range(1, sideWidth)
                    .concat([0])
                    .concat(
                        range(totalPages - sideWidth - 1 - rightWidth - leftWidth, totalPages)
                    );
            }
            // Breaks on both sides
            return range(1, sideWidth)
                .concat([0])
                .concat(range(page - leftWidth, page + rightWidth))
                .concat([0])
                .concat(range(totalPages - sideWidth + 1, totalPages));
        }

        $(function () {
            // Number of items and limits the number of items per page
            var numberOfItems = $(".row.olxElements .elementOlx").length;
            /* console.log(numberOfItems) */
            var limitPerPage = 4;
            // Total pages rounded upwards
            var totalPages = Math.ceil(numberOfItems / limitPerPage);
            // Number of buttons at the top, not counting prev/next,
            // but including the dotted buttons.
            // Must be at least 5:
            var paginationSize = 7;
            var currentPage;

            function showPage(whichPage) {
                /* console.log(whichPage); */
                if (whichPage < 1 || whichPage > totalPages) return false;
                currentPage = whichPage;
                $(".row.olxElements .elementOlx")
                    .hide()
                    .slice((currentPage - 1) * limitPerPage, currentPage * limitPerPage)
                    .show();
                // Replace the navigation items (not prev/next):
                $(".paginationOlx.olxAdsPagination li").slice(1, -1).remove();
                getPageList(totalPages, currentPage, paginationSize).forEach(item => {
                    $("<li>")
                .addClass(
                    "page-item " +
                    (item ? "current-pageOlx " : "") +
                    (item === currentPage ? "active" : "")
                )
                    .append(
                        $("<a>")
                            .addClass("page-link")
                            .attr({
                                href: "javascript:void(0)"
                            })
                            .text(item || "...")
                    )
                    .insertBefore("#next-page-Olx");
            });
                return true;
            }

            // Include the prev/next buttons:
            $(".olxAdsPagination").append(
                $("<li>").addClass("page-item").attr({id: "previous-page-Olx"}).append(
                    $("<a>")
                        .addClass("page-link")
                        .attr({
                            href: "javascript:void(0)"
                        })
                        .text("Prev")
                ),
                $("<li>").addClass("page-item").attr({id: "next-page-Olx"}).append(
                    $("<a>")
                        .addClass("page-link")
                        .attr({
                            href: "javascript:void(0)"
                        })
                        .text("Next")
                )
            );
            // Show the page links
            $(".row.olxElements").show();
            showPage(1);

            // Use event delegation, as these items are recreated later
            $(
                document
            ).on("click", ".paginationOlx li.current-pageOlx:not(.active)", function (e) {
                e.preventDefault();
                return showPage(+$(this).text());
            });
            $("#next-page-Olx").on("click", function (e) {
                e.preventDefault();
                return showPage(currentPage + 1);
            });

            $("#previous-page-Olx").on("click", function (e) {
                e.preventDefault();
                return showPage(currentPage - 1);
            });
        });
    }


    function paginareCarzz() {
        function getPageList(totalPages, page, maxLength) {
            if (maxLength < 5) throw "maxLength must be at least 5";

            function range(start, end) {
                return Array.from(Array(end - start + 1), (_, i) => i + start);
            }

            var sideWidth = maxLength < 9 ? 1 : 2;
            var leftWidth = (maxLength - sideWidth * 2 - 3) >> 1;
            var rightWidth = (maxLength - sideWidth * 2 - 2) >> 1;
            if (totalPages <= maxLength) {
                // no breaks in list
                return range(1, totalPages);
            }
            if (page <= maxLength - sideWidth - 1 - rightWidth) {
                // no break on left of page
                return range(1, maxLength - sideWidth - 1)
                    .concat([0])
                    .concat(range(totalPages - sideWidth + 1, totalPages));
            }
            if (page >= totalPages - sideWidth - 1 - rightWidth) {
                // no break on right of page
                return range(1, sideWidth)
                    .concat([0])
                    .concat(
                        range(totalPages - sideWidth - 1 - rightWidth - leftWidth, totalPages)
                    );
            }
            // Breaks on both sides
            return range(1, sideWidth)
                .concat([0])
                .concat(range(page - leftWidth, page + rightWidth))
                .concat([0])
                .concat(range(totalPages - sideWidth + 1, totalPages));
        }

        $(function () {
            // Number of items and limits the number of items per page
            var numberOfItems = $(".row.carzzElements .elementCarzz").length;
            /* console.log(numberOfItems) */
            var limitPerPage = 4;
            // Total pages rounded upwards
            var totalPages = Math.ceil(numberOfItems / limitPerPage);
            // Number of buttons at the top, not counting prev/next,
            // but including the dotted buttons.
            // Must be at least 5:
            var paginationSize = 7;
            var currentPage;

            function showPage(whichPage) {
                /* console.log(whichPage); */
                if (whichPage < 1 || whichPage > totalPages) return false;
                currentPage = whichPage;
                $(".row.carzzElements .elementCarzz")
                    .hide()
                    .slice((currentPage - 1) * limitPerPage, currentPage * limitPerPage)
                    .show();
                // Replace the navigation items (not prev/next):
                $(".paginationCarzz.carzzAdsPagination li").slice(1, -1).remove();
                getPageList(totalPages, currentPage, paginationSize).forEach(item => {
                    $("<li>")
                .addClass(
                    "page-item " +
                    (item ? "current-pageCarzz " : "") +
                    (item === currentPage ? "active" : "")
                )
                    .append(
                        $("<a>")
                            .addClass("page-link")
                            .attr({
                                href: "javascript:void(0)"
                            })
                            .text(item || "...")
                    )
                    .insertBefore("#next-page-Carzz");
            })
                ;
                return true;
            }

            // Include the prev/next buttons:
            $(".carzzAdsPagination").append(
                $("<li>").addClass("page-item").attr({id: "previous-page-Carzz"}).append(
                    $("<a>")
                        .addClass("page-link")
                        .attr({
                            href: "javascript:void(0)"
                        })
                        .text("Prev")
                ),
                $("<li>").addClass("page-item").attr({id: "next-page-Carzz"}).append(
                    $("<a>")
                        .addClass("page-link")
                        .attr({
                            href: "javascript:void(0)"
                        })
                        .text("Next")
                )
            );
            // Show the page links
            $(".row.carzzElements").show();
            showPage(1);

            // Use event delegation, as these items are recreated later
            $(
                document
            ).on("click", ".paginationCarzz li.current-pageCarzz:not(.active)", function (e) {
                e.preventDefault();
                return showPage(+$(this).text());
            });
            $("#next-page-Carzz").on("click", function (e) {
                e.preventDefault();
                return showPage(currentPage + 1);
            });

            $("#previous-page-Carzz").on("click", function (e) {
                e.preventDefault();
                return showPage(currentPage - 1);
            });
        });
    }

    function paginareBestAuto() {
        function getPageList(totalPages, page, maxLength) {
            if (maxLength < 5) throw "maxLength must be at least 5";

            function range(start, end) {
                return Array.from(Array(end - start + 1), (_, i) => i + start);
            }

            var sideWidth = maxLength < 9 ? 1 : 2;
            var leftWidth = (maxLength - sideWidth * 2 - 3) >> 1;
            var rightWidth = (maxLength - sideWidth * 2 - 2) >> 1;
            if (totalPages <= maxLength) {
                // no breaks in list
                return range(1, totalPages);
            }
            if (page <= maxLength - sideWidth - 1 - rightWidth) {
                // no break on left of page
                return range(1, maxLength - sideWidth - 1)
                    .concat([0])
                    .concat(range(totalPages - sideWidth + 1, totalPages));
            }
            if (page >= totalPages - sideWidth - 1 - rightWidth) {
                // no break on right of page
                return range(1, sideWidth)
                    .concat([0])
                    .concat(
                        range(totalPages - sideWidth - 1 - rightWidth - leftWidth, totalPages)
                    );
            }
            // Breaks on both sides
            return range(1, sideWidth)
                .concat([0])
                .concat(range(page - leftWidth, page + rightWidth))
                .concat([0])
                .concat(range(totalPages - sideWidth + 1, totalPages));
        }

        $(function () {
            // Number of items and limits the number of items per page
            var numberOfItems = $(".row.bestAutoElements .elementBestAuto").length;
            /* console.log(numberOfItems) */
            var limitPerPage = 4;
            // Total pages rounded upwards
            var totalPages = Math.ceil(numberOfItems / limitPerPage);
            // Number of buttons at the top, not counting prev/next,
            // but including the dotted buttons.
            // Must be at least 5:
            var paginationSize = 7;
            var currentPage;

            function showPage(whichPage) {
                /* console.log(whichPage); */
                if (whichPage < 1 || whichPage > totalPages) return false;
                currentPage = whichPage;
                $(".row.bestAutoElements .elementBestAuto")
                    .hide()
                    .slice((currentPage - 1) * limitPerPage, currentPage * limitPerPage)
                    .show();
                // Replace the navigation items (not prev/next):
                $(".paginationBestAuto.bestautoAdsPagination li").slice(1, -1).remove();
                getPageList(totalPages, currentPage, paginationSize).forEach(item => {
                    $("<li>")
                .addClass(
                    "page-item " +
                    (item ? "current-pageBestAuto " : "") +
                    (item === currentPage ? "active" : "")
                )
                    .append(
                        $("<a>")
                            .addClass("page-link")
                            .attr({
                                href: "javascript:void(0)"
                            })
                            .text(item || "...")
                    )
                    .insertBefore("#next-page-BestAuto");
            })
                ;
                return true;
            }

            // Include the prev/next buttons:
            $(".bestautoAdsPagination").append(
                $("<li>").addClass("page-item").attr({id: "previous-page-BestAuto"}).append(
                    $("<a>")
                        .addClass("page-link")
                        .attr({
                            href: "javascript:void(0)"
                        })
                        .text("Prev")
                ),
                $("<li>").addClass("page-item").attr({id: "next-page-BestAuto"}).append(
                    $("<a>")
                        .addClass("page-link")
                        .attr({
                            href: "javascript:void(0)"
                        })
                        .text("Next")
                )
            );
            // Show the page links
            $(".row.publi24Elements").show();
            showPage(1);

            // Use event delegation, as these items are recreated later
            $(
                document
            ).on("click", ".paginationBestAuto li.current-pageBestAuto:not(.active)", function (e) {
                e.preventDefault();
                return showPage(+$(this).text());
            });
            $("#next-page-BestAuto").on("click", function (e) {
                e.preventDefault();
                return showPage(currentPage + 1);
            });

            $("#previous-page-BestAuto").on("click", function (e) {
                e.preventDefault();
                return showPage(currentPage - 1);
            });
        });
    }

    function paginareAuto() {
        function getPageList(totalPages, page, maxLength) {
            if (maxLength < 5) throw "maxLength must be at least 5";

            function range(start, end) {
                return Array.from(Array(end - start + 1), (_, i) => i + start);
            }

            var sideWidth = maxLength < 9 ? 1 : 2;
            var leftWidth = (maxLength - sideWidth * 2 - 3) >> 1;
            var rightWidth = (maxLength - sideWidth * 2 - 2) >> 1;
            if (totalPages <= maxLength) {
                // no breaks in list
                return range(1, totalPages);
            }
            if (page <= maxLength - sideWidth - 1 - rightWidth) {
                // no break on left of page
                return range(1, maxLength - sideWidth - 1)
                    .concat([0])
                    .concat(range(totalPages - sideWidth + 1, totalPages));
            }
            if (page >= totalPages - sideWidth - 1 - rightWidth) {
                // no break on right of page
                return range(1, sideWidth)
                    .concat([0])
                    .concat(
                        range(totalPages - sideWidth - 1 - rightWidth - leftWidth, totalPages)
                    );
            }
            // Breaks on both sides
            return range(1, sideWidth)
                .concat([0])
                .concat(range(page - leftWidth, page + rightWidth))
                .concat([0])
                .concat(range(totalPages - sideWidth + 1, totalPages));
        }

        $(function () {
            // Number of items and limits the number of items per page
            var numberOfItems = $(".row.autoElements .elementAuto").length;
            /* console.log(numberOfItems) */
            var limitPerPage = 4;
            // Total pages rounded upwards
            var totalPages = Math.ceil(numberOfItems / limitPerPage);
            // Number of buttons at the top, not counting prev/next,
            // but including the dotted buttons.
            // Must be at least 5:
            var paginationSize = 7;
            var currentPage;

            function showPage(whichPage) {
                /* console.log(whichPage); */
                if (whichPage < 1 || whichPage > totalPages) return false;
                currentPage = whichPage;
                $(".row.autoElements .elementAuto")
                    .hide()
                    .slice((currentPage - 1) * limitPerPage, currentPage * limitPerPage)
                    .show();
                // Replace the navigation items (not prev/next):
                $(".paginationAuto.autoAdsPagination li").slice(1, -1).remove();
                getPageList(totalPages, currentPage, paginationSize).forEach(item => {
                    $("<li>")
                .addClass(
                    "page-item " +
                    (item ? "current-pageAuto " : "") +
                    (item === currentPage ? "active" : "")
                )
                    .append(
                        $("<a>")
                            .addClass("page-link")
                            .attr({
                                href: "javascript:void(0)"
                            })
                            .text(item || "...")
                    )
                    .insertBefore("#next-page-Auto");
            })
                ;
                return true;
            }

            // Include the prev/next buttons:
            $(".autoAdsPagination").append(
                $("<li>").addClass("page-item").attr({id: "previous-page-Auto"}).append(
                    $("<a>")
                        .addClass("page-link")
                        .attr({
                            href: "javascript:void(0)"
                        })
                        .text("Prev")
                ),
                $("<li>").addClass("page-item").attr({id: "next-page-Auto"}).append(
                    $("<a>")
                        .addClass("page-link")
                        .attr({
                            href: "javascript:void(0)"
                        })
                        .text("Next")
                )
            );
            // Show the page links
            $(".row.publi24Elements").show();
            showPage(1);

            // Use event delegation, as these items are recreated later
            $(
                document
            ).on("click", ".paginationAuto li.current-pageAuto:not(.active)", function (e) {
                e.preventDefault();
                return showPage(+$(this).text());
            });
            $("#next-page-Auto").on("click", function (e) {
                e.preventDefault();
                return showPage(currentPage + 1);
            });

            $("#previous-page-Auto").on("click", function (e) {
                e.preventDefault();
                return showPage(currentPage - 1);
            });
        });
    }


    function resetData() {
        $("#marcaId").val("");
        $("#modelId").val("");
        $("#pretDeLa").val("");
        $("#pretPanaLa").val("");
    }


})

