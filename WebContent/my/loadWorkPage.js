<script type="text/javascript">
    $("#student").click(function(){
        $.post("/class/StudentPage", function(res){
            var res = $.parseJSON(res);
            var list = res.list;
            //$("#homework").append("<a class="collapsed" role="button" data-toggle="collapse" data-parent="#homeworkAccordion" href="#collapseWorkOne" aria-expanded="false" aria-controls="collapseOne">
            // 第一次作业
            //</a>");
            //list.map(function(item, index, array){


            //});

            alert(list[0].theme);
            alert("1");

        });
    });

$("#teacher").click(function(){
    $.post("/class/TeacherPage",function(rs){
        console.log(rs);


    });

});
</script>
<div class="panel panel-default">
    <div class="panel-heading" role="tab" id="workOne">
    <h4 class="panel-title">
    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#homeworkAccordion" href="#collapseWorkOne" aria-expanded="false" aria-controls="collapseOne">
    第一次作业
    </a>
    </h4>
    </div>
    <div id="collapseWorkOne" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
    <div class="panel-body">下载链接1</div>
    </div>
    </div>
    <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="workTwo">
    <h4 class="panel-title">
    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#homeworkAccordion" href="#collapseWorkTwo" aria-expanded="false" aria-controls="collapseTwo">
    第二次作业
    </a>
    </h4>
    </div>
    <div id="collapseWorkTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
    <div class="panel-body">下载链接2</div>
    </div>
    </div>
    <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="workThree">
    <h4 class="panel-title">
    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#homeworkAccordion" href="#collapseWorkThree" aria-expanded="false" aria-controls="collapseThree">
    第三次作业
    </a>
    </h4>
    </div>
    <div id="collapseWorkThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
    <div class="panel-body">下载链接3</div>
    </div>
    </div>

    <form action="/class/UploadWork" method="post" enctype="multipart/form-data">
    <input type="file" name="file" id="file" multiple="true"  />
    <input type="submit" value="提交" />
    </form>


        <!-- 老师发布作业功能 -->
    <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModalWork">发布作业 </button>

    <div class="modal fade" id="myModalWork" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
    <div class="modal-content">

    <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
<h4 class="modal-title" id="myModalLabelWork">发布作业</h4>
    </div>

    <form class="form-horizontal" action="/class/IssueWork" method="post">
    <div class="modal-body">
    <div class="form-group">
    <div class="col-sm-offset-1 col-sm-9">
    <textarea class="form-control" rows="3" placeholder="请输入作业内容" name="theme"></textarea>
    </div>
    </div>

    <div class="form-group">
    <label  class="col-sm-3 control-label">Deadline</label>
    <div class="col-sm-3">
    <select class="form-control" name="year">
    <option value="2016">2016年</option>
<option value="2017">2017年</option>
<option value="2018">2018年</option>
<option value="2019">2019年</option>
<option value="2020">2020年</option>
</select>
</div>
<div class="col-sm-2">
    <select class="form-control" name="month">
    <option value="1">1月</option>
<option value="2">2月</option>
<option value="3">3月</option>
<option value="4">4月</option>
<option value="5">5月</option>
<option value="6">6月</option>
<option value="7">7月</option>
<option value="8">8月</option>
<option value="9">9月</option>
<option value="10">10月</option>
<option value="11">11月</option>
<option value="12">12月</option>
</select>
</div>
<div class="col-sm-2">
    <select class="form-control" name="day">
    <option value="1">1日</option>
<option value="2">2日</option>
<option value="3">3日</option>
<option value="4">4日</option>
<option value="5">5日</option>
<option value="6">6日</option>
<option value="7">7日</option>
<option value="8">8日</option>
<option value="9">9日</option>
<option value="10">10日</option>
<option value="11">11日</option>
<option value="12">12日</option>
<option value="13">13日</option>
<option value="14">14日</option>
<option value="15">15日</option>
<option value="16">16日</option>
<option value="17">17日</option>
<option value="18">18日</option>
<option value="19">19日</option>
<option value="20">20日</option>
<option value="21">21日</option>
<option value="22">22日</option>
<option value="23">23日</option>
<option value="24">24日</option>
<option value="25">25日</option>
<option value="26">26日</option>
<option value="27">27日</option>
<option value="28">28日</option>
<option value="29">29日</option>
<option value="30">30日</option>
<option value="31">31日</option>
</select>
</div>
</div>
</div>

<div class="modal-footer">
    <button type="submit" data-toggle="modal" data-target="#myModalWork" id="issueWork">发布</button>
    </div>
    </form>
    </div>
    </div>
    </div>