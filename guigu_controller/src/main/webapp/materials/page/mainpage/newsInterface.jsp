<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(function () {
        refresh();
    });

    function refresh() {
        $.ajax({
            type: 'POST',
            url: 'https://www.apiopen.top/journalismApi',
            success: function (msg) {
                if (msg.code != 200) {
                    $('#new_Info').html("<p style='color:red'>网络连接错误 -> 404</p>");
                    return;
                }
                $('#new_tabs').tabs({
                    fit: true,
                });
                var recommend_Info = "";
                for (var va in msg.data) {
                    /**
                     * 拼接内容
                     * 图片+标题
                     * @type {string}
                     */
                    var new_Info = "";
                    var new_main = msg.data[va];
                    for (var i = 0; i < new_main.length; i++) {
                        if (new_main[i].picInfo.length != 0) {
                            if (new_main[0].category == "推荐") {
                                recommend_Info += '<table><tr><td><img src="' + new_main[i].picInfo[0].url + '" width="70" height="70"/></td><td><h4><a target="_blank" style="text-decoration: none" name="' + new_main[i].title + '" onclick="clickNew(this);" id="' + new_main[i].link + '">' + new_main[i].title + '</a></h4></td></tr></table><br/>';
                            }
                            new_Info += '<table><tr><td><img src="' + new_main[i].picInfo[0].url + '" width="70" height="70"/></td><td><h4><a target="_blank" name="' + new_main[i].title + '" style="text-decoration: none" onclick="clickNew(this);" id="' + new_main[i].link + '">' + new_main[i].title + '</a></h4></td></tr></table><br/>';
                        }
                    }
                    if (new_main[0].category != "推荐") {
                        $('#new_tabs').tabs('add', {
                            title: new_main[0].category,
                            content: new_Info,
                        });
                    }
                }
                $('#new_tabs').tabs('add', {
                    title: '推荐',
                    content: recommend_Info,
                });
            }
        });
    }

    function clickNew(obj) {
        var url = $(obj).attr('id');
        var title = $(obj).attr('name');
        var pageInfo = '<div id="new_demosgo"><iframe align="top" src="' + url + '" width="420" height="400" scrolling="yes"></iframe><a id="new_closeWin" style="margin-left: 365px;"></a></div>';
        $(pageInfo).window({
            title: title,
            collapsible: false,
            minimizable: false,
            maximizable: false,
            resizable: false,
            closable: false,
            width: 438,
            height: 466,
            modal: true,
            onClose: function () {
                $(this).window('destroy');
            },
        });
        $('#new_closeWin').linkbutton({
            text: '关闭',
            iconCls: 'icon-main_closenews',
            onClick: function () {
                $('#new_demosgo').window('close');
            }
        });
    }
</script>
<span id="new_Info"></span>
<div id="new_tabs">
</div>
