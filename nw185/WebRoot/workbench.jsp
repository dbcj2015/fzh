<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html> 
<html lang="en"> 
<head> 
    <meta charset="utf-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1"> 
    <title>工作台</title> 


<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/easyui/themes/uimaker/easyui.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/base.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/workbench.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/easyui/script/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/easyui/script/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/easyui/script/easyui-lang-zh_CN.js"></script>
</head> 
<body>
    <div class="container">
        <div id="hd">
            
        </div>

        <div id="bd">
            <div class="bd-content">
                <div class="right-zone">
                    <div class="inform item-box">
                        <div class="inform-hd">
                            <label>通知公告</label>
                            <a href="javascript:;">更多<span>&gt;</span></a>
                        </div>
                        <ul>
                            <li>
                                <span></span>
                                <a href="javascript:;" class="ellipsis">关于调整个人短信支付交易限额的通告<i></i></a>
                                <label>04-13</label>
                            </li>
                            <li>
                                <span></span>
                                <a href="javascript:;" class="ellipsis">关于国家开发银行2017年第五期及第七期金融债...<i></i></a>
                                <label>04-12</label>
                            </li>
                            <li>
                                <span></span>
                                <a href="javascript:;" class="ellipsis">关于国家开发银行2017年第七期金融债券柜台市…</a>
                                <label>04-11</label>
                            </li>
                            <li>
                                <span></span>
                                <a href="javascript:;" class="ellipsis">关于销售国家开发银行2017年第七期金融债券的…</a>
                                <label>04-10</label>
                            </li>
                            <li>
                                <span></span>
                                <a href="javascript:;" class="ellipsis">关于开办账户农产品和账户基本金属连续产品业…</a>
                                <label>04-09</label>
                            </li>
                        </ul>
                    </div>
                    <div class="price item-box">
                        <div class="inform-hd">
                            <label>采购项目</label>
                            <a href="javascript:;">更多<span>&gt;</span></a>
                        </div>
                        <ul>
                            <li>
                                <span></span>
                                <a href="javascript:;" class="ellipsis">2017年ATM机采购计划</a>
                                <label>04-13</label>
                            </li>
                            <li>
                                <span></span>
                                <a href="javascript:;" class="ellipsis">2017年POS机采购计划</a>
                                <label>04-12</label>
                            </li>
                            <li>
                                <span></span>
                                <a href="javascript:;" class="ellipsis">...</a>
                                <label>04-11</label>
                            </li>
                            <li>
                                <span></span>
                                <a href="javascript:;" class="ellipsis">....</a>
                                <label>04-10</label>
                            </li>
                            <li>
                                <span></span>
                                <a href="javascript:;" class="ellipsis">....</a>
                                <label>04-09</label>
                            </li>
                            
                        </ul>
                    </div>
                    <div class="attached item-box">
                        <div class="inform-hd">
                            <label>常用附件下载</label>
                            <a href="javascript:;">更多<span>&gt;</span></a>
                        </div>
                        <div class="attached-tab">
                            <a href="javascript:;" class="current item-left" attached="public-attached">公开附件</a>
                            <a href="javascript:;" class="item-right" attached="inner-attached">内部附件</a>
                        </div>
                        <ul class="public-attached">
                            <li>
                                <span></span>
                                <a href="javascript:;" class="ellipsis">OFFICE办公套件</a>
                            </li>
                            <li>
                                <span></span>
                                <a href="javascript:;" class="ellipsis">WINRAR下载</a>
                            </li>
                            <li>
                                <span></span>
                                <a href="javascript:;" class="ellipsis">Foxmail邮件客户端</a>
                            </li>
                            <li>
                                <span></span>
                                <a href="javascript:;" class="ellipsis">....</a>
                            </li>
                            <li>
                                <span></span>
                                <a href="javascript:;" class="ellipsis">....</a>
                            </li>
                            <li>
                                <span></span>
                                <a href="javascript:;" class="ellipsis">....</a>
                            </li>
                        </ul>
                        <ul class="inner-attached hide">
                           <li>
                                <span></span>
                                <a href="javascript:;" class="ellipsis">工商银行行政管理条例</a>
                            </li>
                            <li>
                                <span></span>
                                <a href="javascript:;" class="ellipsis">供应商招标流程</a>
                            </li>
                            <li>
                                <span></span>
                                <a href="javascript:;" class="ellipsis">...</a>
                            </li>
                            <li>
                                <span></span>
                                <a href="javascript:;" class="ellipsis">...</a>
                            </li>
                            <li>
                                <span></span>
                                <a href="javascript:;" class="ellipsis">...</a>
                            </li>
                            <li>
                                <span></span>
                                <a href="javascript:;" class="ellipsis">...</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="center-part">
                    <div class="center-items todo">
                        <div class="calendar-part">
                             <div class="easyui-calendar" style="width:205px;height:231px;"></div>
                        </div>
                        <ul class="work-items clearfix">
                            <li>
                                <div class="work-inner">
                                    <div class="work-item green">
                                        <i class="iconfont">&#xe61f;</i>
                                        <span class="num">14&nbsp;<span class="unit">个</span></span>
                                        <label>待办未处理</label>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="work-inner">
                                    <div class="work-item red">
                                         <i class="iconfont">&#xe622;</i>
                                        <span class="num">6&nbsp;<span class="unit">条</span></span>
                                        <label>预警信息未读</label>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="work-inner">
                                    <div class="work-item yellow">
                                         <i class="iconfont">&#xe61d;</i>
                                        <span class="num">9&nbsp;<span class="unit">封</span></span>
                                        <label>邮件未读</label>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="work-inner">
                                    <div class="work-item blue">
                                         <i class="iconfont">&#xe621;</i>
                                        <span title="12,00.00万" class="num">12,456.78&nbsp;<span class="unit">万</span></span>
                                        <label>固定资产总额</label>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="work-inner">
                                    <div class="work-item purple">
                                         <i class="iconfont">&#xe61e;</i>
                                        <span title="2000,00万" class="num">100,00&nbsp;<span class="unit">万</span></span>
                                        <label>2017年采购合同金额</label>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="work-inner">
                                    <div class="work-item gray">
                                         <i class="iconfont">&#xe620;</i>
                                        <span class="num">4&nbsp;<span class="unit">个</span></span>
                                        <label>供应商</label>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="center-items chart0 clearfix">
                        <div class="chart0-item">
                            <div class="item-inner">
                                <div class="item-content">
                                    <div class="content-hd">资产分布(机构)</div>
                                    <div class="chart-chart" id="chart0"></div>
                                </div>
                            </div>
                        </div>
                        <div class="chart0-item">
                            <div class="item-inner">
                                <div class="item-content">
                                    <div class="content-hd">资产分布(类型)</div>
                                    <div class="chart-chart" id="chart1"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="center-items chart1">
                        <div class="chart1-inner">
                             <div class="item-hd">设备维护成本</div>
                             <div class="chart1-chart" id="chart3"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="ft"></div>
    </div>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/echarts/echarts-all.js"></script>
    
  

    
    <script type="text/javascript">
    //chart0

    $(document).ready(function(){
        var option0 = {
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient : 'vertical',
                x : 'left',
                data:['河北省行','石家庄分行','保定分行','张家口分行','邯郸分行'],
                show:true
            },
            toolbox: {
                show : false,
                feature : {
                    mark : {show: true},
                    dataView : {show: true, readOnly: false},
                    magicType : {
                        show: true, 
                        type: ['pie', 'funnel'],
                        option: {
                            funnel: {
                                x: '25%',
                                width: '50%',
                                funnelAlign: 'center',
                                max: 1548
                            }
                        }
                    },
                    restore : {show: true},
                    saveAsImage : {show: true}
                }
            },
            calculable : true,
            series : [
                {
                    name:'资产分布(机构)',
                    type:'pie',
                    radius : ['50%', '80%'],
                    itemStyle : {
                        normal : {
                            label : {
                                show : true
                            },
                            labelLine : {
                                show : true
                            }
                        },
                        emphasis : {
                            label : {
                                show : true,
                                position : 'center',
                                textStyle : {
                                    fontSize : '30',
                                    fontWeight : 'bold'
                                }
                            }
                        }
                    },
                    data:[
                        {value:335, name:'河北省行'},
                        {value:310, name:'石家庄分行'},
                        {value:234, name:'保定分行'},
                        {value:135, name:'张家口分行'},
                        {value:1548, name:'邯郸分行'}
                    ]
                }
            ]
        };

      var myChart0 = echarts.init(document.getElementById('chart0'));
      myChart0.setOption(option0);

      //chart1
     var option1 = {
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient : 'vertical',
                x : 'left',
                data:['打印机','台式电脑','自动柜员机','笔记本','其他'],
                show:true
            },
            toolbox: {
                show : false,
                feature : {
                    mark : {show: true},
                    dataView : {show: true, readOnly: false},
                    magicType : {
                        show: true, 
                        type: ['pie', 'funnel'],
                        option: {
                            funnel: {
                                x: '25%',
                                width: '50%',
                                funnelAlign: 'center',
                                max: 1548
                            }
                        }
                    },
                    restore : {show: true},
                    saveAsImage : {show: true}
                }
            },
            calculable : true,
            series : [
                {
                    name:'资产分布(类型)',
                    type:'pie',
                    radius : ['50%', '80%'],
                    itemStyle : {
                        normal : {
                            label : {
                                show : true
                            },
                            labelLine : {
                                show : true
                            }
                        },
                        emphasis : {
                            label : {
                                show : true,
                                position : 'center',
                                textStyle : {
                                    fontSize : '30',
                                    fontWeight : 'bold'
                                }
                            }
                        }
                    },
                    data:[
                        {value:929, name:'打印机'},
                        {value:3212, name:'台式电脑'},
                        {value:7700, name:'自动柜员机'},
                        {value:1350, name:'笔记本'},
                        {value:3300, name:'其他'}
                    ]
                }
            ]
        };
        var myChart1 = echarts.init(document.getElementById('chart1'));
        myChart1.setOption(option1);

        var option3 = {
            tooltip : {
                trigger: 'axis'
            },
            legend: {
                data:['设备维护成本'],
                show:true
            },
            toolbox: {
                show : false,
                feature : {
                    mark : {show: true},
                    dataView : {show: true, readOnly: false},
                    magicType : {show: true, type: ['line', 'bar']},
                    restore : {show: true},
                    saveAsImage : {show: true}
                }
            },
            calculable : true,
            xAxis : [
                {
                    type : 'category',
                    data : ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月']
                }
            ],
            yAxis : [
                {
                    type : 'value'
                }
            ],
            series : [
                {
                    name:'设备维护成本',
                    type:'line',
                    data:[7328, 2381 , 8221, 3812, 8821 , 3288, 7892 , 6780 , 14320 , 8819 , 2881,6666],
                    markPoint : {
                        data : [
                            {type : 'max', name: '最大值'},
                            {type : 'min', name: '最小值'}
                        ]
                    },
                    markLine : {
                        data : [
                            {type : 'average', name: '平均值'}
                        ]
                    }
                }
            ]
        };

        var myChart3 = echarts.init(document.getElementById('chart3'));
        myChart3.setOption(option3);         
          
    });
        
    //公开附件tab事件处理
    $(".attached-tab").on("click","a",function(){
        $(this).closest(".attached-tab").find("a").removeClass("current");
        $(this).addClass("current");
        $(this).closest(".attached").find("ul").addClass("hide");   
        $(this).closest(".attached").find("ul." + $(this).attr("attached")).removeClass("hide");    
    })
                    
    </script>
</body> 
</html>
