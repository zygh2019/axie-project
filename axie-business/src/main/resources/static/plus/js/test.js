;!function () {
    var form = layui.form,
        laytpl = layui.laytpl, $ = layui.$;

    var datas
    $.ajax({
        url: "http://127.0.0.1:8080/axie/getCount",
        type: "GET",
        dataType: "json",
        success: function (data) {
            datas = data.data;
            var getTpl = document.getElementById('demo').innerHTML
                , view = document.getElementById('view');


            laytpl(getTpl).render(datas, function (html) {
                view.innerHTML = html;
            });

            form.render(); //更新全部

        }
    });


}()


