/**
 * Create with WebStorm
 * Author: Daxiu Huang
 * CreateTime: 2017/9/5 16:43
 */
var data = {
    "title": "标题--在线试卷",
    "exam": [
        {
            "title": "单项选择题",
            "infos": null,
            "values": [
                {
                    "type": 1,
                    "questionStem": "管理的首要职能是",
                    "options": [
                        "计划",
                        "组织",
                        "领导",
                        "控制"
                    ],
                    "answer": [
                        "A"
                    ],
                    "analysis": null
                },
                {
                    "type": 1,
                    "questionStem": "java好还是.net好",
                    "options": [
                        "java",
                        ".net",
                        "都不好",
                        
                    ],
                    "answer": [
                        "B"
                    ],
                    "analysis": null
                },
                {
                    "type": 1,
                    "questionStem": "你现在学是的什么？",
                    "options": [
                        "吹牛",
                        "撩妹",
                        "吃饭",
                        "睡觉"
                    ],
                    "answer": [
                        "A"
                    ],
                    "analysis": null
                },
                {
                    "type": 1,
                    "questionStem": "梅奥的人际关系学说属于",
                    "options": [
                        "行为科学理论",
                        "科学管理理论",
                        "一般管理理论",
                        "权变管理理论"
                    ],
                    "answer": [
                        "A"
                    ],
                    "analysis": null
                },
                {
                    "type": 1,
                    "questionStem": "电子产品的更新换代速度越来越快，电子企业面临的环境不确定性越来越高，该环",
                    "options": [
                        "简单稳定",
                        "复杂稳定",
                        "简单动态",
                        "复杂动态"
                    ],
                    "answer": [
                        "D"
                    ],
                    "analysis": null
                }
            ]
        },
        {
            "title": "多项选择题",
            "infos": null,
            "values": [
                {
                    "type": 2,
                    "questionStem": "下列属于高层管理者的有",
                    "options": [
                        "董事长",
                        "首席执行官",
                        "总经理",
                        "项目经理",
                        "车间主任"
                    ],
                    "answer": [
                        "A",
                        "B",
                        "C"
                    ],
                    "analysis": null
                },
                {
                    "type": 2,
                    "questionStem": "组织环境的特点有",
                    "options": [
                        "客观性",
                        "复杂性",
                        "关联性",
                        "确定性",
                        "层次性"
                    ],
                    "answer": [
                        "A",
                        "B",
                        "C",
                        "E"
                    ],
                    "analysis": null
                }
            ]
        },
       
        
    ]
};
function test(test_id) {
    if(test_id!=""){
        //$.ajax({
            //type : 'POST',
            //url : 'data/exam.json',
            //data : {'testId':test_id},
            //dataType : "json",
            //success : function(data){
            console.log(data);
            var titleB = data.title;
            var exam = data.exam;
            var test_box = '';

            $.each(exam, function(h, exam) {
                var title = exam.title;
                var info = exam.infos!=null?'<h4 class="jxz-title">'+exam.infos+'</h4>':'';
                var test = exam.values;
                var topic_box = '';

                $.each(test, function(i, topic) {//1单选2多选3判断4填空5问答8论述题6完型填空7阅读理解
                    var type = topic.type;
                    var options = topic.options;
                    var answer = topic.answer;
                    var analysis = topic.analysis==null||topic.analysis==""?"无":topic.analysis;
                    var option_box = '';//题目

                    if(type==1){
                        //answer_op = '';
                        $.each(options, function(j, option) {
                            var op = convert(j);
                            option_box += `
                                    <div class="jxz-option radio">
                                        <label>
                                            <input name="test`+h+''+i+`" type="radio" value="`+op+`"> `+op+`：`+option+`
                                        </label>
                                    </div>
                                    `;
                        });

                    }else if(type==2){
                        //answer_op = '';
                        $.each(options, function(j, option) {
                            var op = convert(j);
                            option_box += `
                                    <div class="jxz-option checkbox">
                                        <label>
                                            <input name="test`+h+''+i+`" type="checkbox" value="`+op+`"> `+op+`：`+option+`
                                        </label>
                                    </div>
                                    `;
                        });


                    }else if(type==3){

                        option_box = `
                                <div class="jxz-option radio">
                                    <label>
                                        <input name="test`+h+''+i+`" type="radio" value="1"> 正确
                                    </label>
                                </div>
                                <div class="jxz-option radio">
                                    <label>
                                        <input name="test`+h+''+i+`" type="radio" value="0"> 错误
                                    </label>
                                </div>
                                `;
                    }else if(type==4){

                        option_box += `
                                <div class="jxz-option">
                                    <textarea name="test`+h+''+i+`" class="form-control" style="width: 50%" rows="5" placeholder="答案以空格隔开"></textarea>
                                </div>
                                `;
                    }else if(type==5||type==8){

                        option_box += `
                                <div class="jxz-option">
                                    <textarea name="test5" class="form-control" style="width: 50%" rows="5" placeholder=""></textarea>
                                </div>
                                `;
                    }else if(type==6){

                        $.each(options, function(j, option) {
                            var op = convert(j);
                            option_box += `
                                    <div class="jxz-option radio-inline">
                                        <label>
                                            `+op+`：`+option+`
                                        </label>
                                    </div>
                                    `;
                        });
                        option_box += `
                                <div class="jxz-option">
                                    <textarea name="test`+h+''+i+`" class="form-control" style="width: 50%" rows="5" placeholder="答案以空格隔开"></textarea>
                                </div>`;
                    }else if(type==7){

                        $.each(options, function(j, option) {
                            var op = convert(j);
                            option_box += `
                                    <div class="jxz-option radio">
                                        <label>
                                            <input name="test`+h+''+i+`" type="radio" value="`+op+`"> `+op+`：`+option+`
                                        </label>
                                    </div>
                                    `;
                        });
                    }

                    var answer_op = '';//答案
                    if(type==3){
                        $.each(answer, function(i, aw) {
                            answer_op += aw==1 ? "正确" : "错误";
                        });
                    }else{
                        $.each(answer, function(i, aw) {
                            answer_op += answer.length==(i+1) ? aw : aw+" ";
                        });
                    }
                    topic_box += `
                            <div class="testCon" data-type="`+type+`" data-answer="`+answer_op+`">
                                <h4 class="jxz-title">`+topic.questionStem+`</h4>
                                `+option_box+`
                                <div class="topic-answer">
                                   <p>您的答案：<span class="userAnswer"></span></p>
                                   <p>正确答案：`+answer_op+`</p>
                                   <p>解析：`+analysis+`</p>
                                </div>
                            </div>
                            `;

                });
                test_box += `
                            <div class="jxz-box col-md-12">
                            <h4 class="tesTitle">`+title+`</h4>
                            `+info+`
                            `+topic_box+`
                        </div>
                        `;
            });

            var test_html = `
                    <div class="page-header">
                        <h3 class="text-center">`+titleB+`</h3>
                    </div>
                    <form class="" id="testForm">
                        <div class="test-form-box">
                            `+test_box+`
                        </div>
                        <div class="form-group assignment">
                            <button type="button" class="btn btn-primary" onclick="assignment()">交卷</button>
                        </div>
                    </form>`;
            $('#testArea').html(test_html)
            //},
            //error:function(data){
                //alert("网络异常，请稍后重试");
            //}
        //});
    }else{
        alert("试题获取失败！");
    }
}
//交卷
function assignment(){
    $(".testCon h4").css("color","#555");
    var _temp_tip = "yes";
    var tall = 0;
    $(".testCon").each(function(i){
        var type = $(this).attr("data-type");
        if(type==2){
            if($(this).find('input[type="checkbox"]:checked').val() == undefined){
                _temp_tip = "no";
                $(this).find("h4").css("color","#00B895");
            }
        }else if(type==1||type==3||type==7){
            if($(this).find('input[type="radio"]:checked').val() == undefined){
                _temp_tip = "no";
                $(this).find("h4").css("color","#00B895");
            }
        }else if(type==4||type==5||type==8||type==6){
            if($.trim($(this).find('textarea').val()) == ''){
                _temp_tip = "no";
                $(this).find("h4").css("color","#00B895");
            }
        }
        tall++;
    });

    if(_temp_tip == "no"){
        alert("还有题目没做完");
        return;
    }

    var err = 0;
    $(".testCon").each(function(i){
        var type = $(this).attr("data-type");
        var aw = $(this).attr("data-answer");
        var set_answer = '';

        if(type==2){

            var ckAarray = $(this).find('input[type="checkbox"]:checked');
            var ans = '';
            ckAarray.each(function (i,item) {
                ans += ckAarray.length==i+1?item.value:item.value+" ";
            });
            if(ans != aw){
                $(this).find("h4").css("color","red");
                err++;
            }
            set_answer = ans;

        }else if(type==1||type==7){

            var rd = $(this).find('input[type="radio"]:checked').val();
            if(rd != aw){
                $(this).find("h4").css("color","red");
                err++;
            }
            set_answer = rd;

        }else if(type==3){

            var rpd = $(this).find('input[type="radio"]:checked').val();
            rpd = rpd==0 ? "错误" : (rpd==1 ? "正确" : "");
            if(rpd != aw){
                $(this).find("h4").css("color","red");
                err++;
            }
            set_answer = rpd;

        }else if(type==4||type==5||type==8||type==6){

            var textVal = $.trim($(this).find('textarea').val());
            if(textVal!= aw){
                $(this).find("h4").css("color","red");
                err++;
            }
            set_answer = textVal;
        }

        $(this).find("span.userAnswer").text(set_answer);

    });
    $(".topic-answer").show();
}
//数字转换成大写字母
function convert(num){
    num = num + 1;
    return num <= 26 ? String.fromCharCode(num + 64) : convert(~~((num - 1) / 26)) + convert(num % 26 || 26);
}