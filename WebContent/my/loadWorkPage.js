<script type="text/javascript">
    $("#student").click(function(){
        $.post("/class/StudentPage", function(res){
            var res = $.parseJSON(res);
            var list = res.list;
            //$("#homework").append("<a class="collapsed" role="button" data-toggle="collapse" data-parent="#homeworkAccordion" href="#collapseWorkOne" aria-expanded="false" aria-controls="collapseOne">
            // ��һ����ҵ
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
    ��һ����ҵ
    </a>
    </h4>
    </div>
    <div id="collapseWorkOne" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
    <div class="panel-body">��������1</div>
    </div>
    </div>
    <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="workTwo">
    <h4 class="panel-title">
    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#homeworkAccordion" href="#collapseWorkTwo" aria-expanded="false" aria-controls="collapseTwo">
    �ڶ�����ҵ
    </a>
    </h4>
    </div>
    <div id="collapseWorkTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
    <div class="panel-body">��������2</div>
    </div>
    </div>
    <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="workThree">
    <h4 class="panel-title">
    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#homeworkAccordion" href="#collapseWorkThree" aria-expanded="false" aria-controls="collapseThree">
    ��������ҵ
    </a>
    </h4>
    </div>
    <div id="collapseWorkThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
    <div class="panel-body">��������3</div>
    </div>
    </div>

    <form action="/class/UploadWork" method="post" enctype="multipart/form-data">
    <input type="file" name="file" id="file" multiple="true"  />
    <input type="submit" value="�ύ" />
    </form>


        <!-- ��ʦ������ҵ���� -->
    <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModalWork">������ҵ </button>

    <div class="modal fade" id="myModalWork" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
    <div class="modal-content">

    <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
<h4 class="modal-title" id="myModalLabelWork">������ҵ</h4>
    </div>

    <form class="form-horizontal" action="/class/IssueWork" method="post">
    <div class="modal-body">
    <div class="form-group">
    <div class="col-sm-offset-1 col-sm-9">
    <textarea class="form-control" rows="3" placeholder="��������ҵ����" name="theme"></textarea>
    </div>
    </div>

    <div class="form-group">
    <label  class="col-sm-3 control-label">Deadline</label>
    <div class="col-sm-3">
    <select class="form-control" name="year">
    <option value="2016">2016��</option>
<option value="2017">2017��</option>
<option value="2018">2018��</option>
<option value="2019">2019��</option>
<option value="2020">2020��</option>
</select>
</div>
<div class="col-sm-2">
    <select class="form-control" name="month">
    <option value="1">1��</option>
<option value="2">2��</option>
<option value="3">3��</option>
<option value="4">4��</option>
<option value="5">5��</option>
<option value="6">6��</option>
<option value="7">7��</option>
<option value="8">8��</option>
<option value="9">9��</option>
<option value="10">10��</option>
<option value="11">11��</option>
<option value="12">12��</option>
</select>
</div>
<div class="col-sm-2">
    <select class="form-control" name="day">
    <option value="1">1��</option>
<option value="2">2��</option>
<option value="3">3��</option>
<option value="4">4��</option>
<option value="5">5��</option>
<option value="6">6��</option>
<option value="7">7��</option>
<option value="8">8��</option>
<option value="9">9��</option>
<option value="10">10��</option>
<option value="11">11��</option>
<option value="12">12��</option>
<option value="13">13��</option>
<option value="14">14��</option>
<option value="15">15��</option>
<option value="16">16��</option>
<option value="17">17��</option>
<option value="18">18��</option>
<option value="19">19��</option>
<option value="20">20��</option>
<option value="21">21��</option>
<option value="22">22��</option>
<option value="23">23��</option>
<option value="24">24��</option>
<option value="25">25��</option>
<option value="26">26��</option>
<option value="27">27��</option>
<option value="28">28��</option>
<option value="29">29��</option>
<option value="30">30��</option>
<option value="31">31��</option>
</select>
</div>
</div>
</div>

<div class="modal-footer">
    <button type="submit" data-toggle="modal" data-target="#myModalWork" id="issueWork">����</button>
    </div>
    </form>
    </div>
    </div>
    </div>