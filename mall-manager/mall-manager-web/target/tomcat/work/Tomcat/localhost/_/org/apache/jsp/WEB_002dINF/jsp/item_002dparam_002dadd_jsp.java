/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-07-02 13:50:12 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class item_002dparam_002dadd_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<table cellpadding=\"5\" style=\"margin-left: 30px\" id=\"itemParamAddTable\" class=\"itemParam\">\n");
      out.write("\t<tr>\n");
      out.write("\t\t<td>商品类目:</td>\n");
      out.write("\t\t<td><a href=\"javascript:void(0)\" class=\"easyui-linkbutton selectItemCat\">选择类目</a> \n");
      out.write("\t\t\t<input type=\"hidden\" name=\"cid\" style=\"width: 280px;\"></input>\n");
      out.write("\t\t</td>\n");
      out.write("\t</tr>\n");
      out.write("\t<tr class=\"hide addGroupTr\">\n");
      out.write("\t\t<td>规格参数:</td>\n");
      out.write("\t\t<td>\n");
      out.write("\t\t\t<ul>\n");
      out.write("\t\t\t\t<li><a href=\"javascript:void(0)\" class=\"easyui-linkbutton addGroup\">添加分组</a></li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t</td>\n");
      out.write("\t</tr>\n");
      out.write("\t<tr>\n");
      out.write("\t\t<td></td>\n");
      out.write("\t\t<td>\n");
      out.write("\t\t\t<a href=\"javascript:void(0)\" class=\"easyui-linkbutton submit\">提交</a>\n");
      out.write("\t    \t<a href=\"javascript:void(0)\" class=\"easyui-linkbutton close\">关闭</a>\n");
      out.write("\t\t</td>\n");
      out.write("\t</tr>\n");
      out.write("</table>\n");
      out.write("<div  class=\"itemParamAddTemplate\" style=\"display: none;\">\n");
      out.write("\t<li class=\"param\">\n");
      out.write("\t\t<ul>\n");
      out.write("\t\t\t<li>\n");
      out.write("\t\t\t\t<input class=\"easyui-textbox\" style=\"width: 150px;\" name=\"group\"/>&nbsp;<a href=\"javascript:void(0)\" class=\"easyui-linkbutton addParam\"  title=\"添加参数\" data-options=\"plain:true,iconCls:'fa fa-plus'\"></a>\n");
      out.write("\t\t\t</li>\n");
      out.write("\t\t\t<li>\n");
      out.write("\t\t\t\t<span>|-------</span><input  style=\"width: 150px;\" class=\"easyui-textbox\" name=\"param\"/>&nbsp;<a href=\"javascript:void(0)\" class=\"easyui-linkbutton delParam\" title=\"删除\" data-options=\"plain:true,iconCls:'fa fa-minus'\"></a>\t\t\t\t\t\t\n");
      out.write("\t\t\t</li>\n");
      out.write("\t\t</ul>\n");
      out.write("\t</li>\n");
      out.write("</div>\n");
      out.write("<script style=\"text/javascript\">\n");
      out.write("\t$(function(){\n");
      out.write("\t\tTT.initItemCat({\n");
      out.write("\t\t\tfun:function(node){\n");
      out.write("\t\t\t$(\".addGroupTr\").hide().find(\".param\").remove();\n");
      out.write("\t\t\t\t//  判断选择的目录是否已经添加过规格\n");
      out.write("\t\t\t  $.getJSON(\"/item/param/query/itemcatid/\" + node.id,function(data){\n");
      out.write("\t\t\t\t  if(data.status == 200 && data.data){\n");
      out.write("\t\t\t\t\t  $.messager.alert(\"提示\", \"该类目已经添加，请选择其他类目。\", undefined, function(){\n");
      out.write("\t\t\t\t\t\t $(\"#itemParamAddTable .selectItemCat\").click();\n");
      out.write("\t\t\t\t\t  });\n");
      out.write("\t\t\t\t\t  return ;\n");
      out.write("\t\t\t\t  }\n");
      out.write("\t\t\t\t  $(\".addGroupTr\").show();\n");
      out.write("\t\t\t  });\n");
      out.write("\t\t\t}\n");
      out.write("\t\t});\n");
      out.write("\t\t\n");
      out.write("\t\t$(\".addGroup\").click(function(){\n");
      out.write("\t\t\t  var temple = $(\".itemParamAddTemplate li\").eq(0).clone();\n");
      out.write("\t\t\t  $(this).parent().parent().append(temple);\n");
      out.write("\t\t\t  temple.find(\".addParam\").click(function(){\n");
      out.write("\t\t\t\t  var li = $(\".itemParamAddTemplate li\").eq(2).clone();\n");
      out.write("\t\t\t\t  li.find(\".delParam\").click(function(){\n");
      out.write("\t\t\t\t\t  $(this).parent().remove();\n");
      out.write("\t\t\t\t  });\n");
      out.write("\t\t\t\t  li.appendTo($(this).parentsUntil(\"ul\").parent());\n");
      out.write("\t\t\t  });\n");
      out.write("\t\t\t  temple.find(\".delParam\").click(function(){\n");
      out.write("\t\t\t\t  $(this).parent().remove();\n");
      out.write("\t\t\t  });\n");
      out.write("\t\t });\n");
      out.write("\t\t\n");
      out.write("\t\t$(\"#itemParamAddTable .close\").click(function(){\n");
      out.write("\t\t\t$(\".panel-tool-close\").click();\n");
      out.write("\t\t});\n");
      out.write("\t\t\n");
      out.write("\t\t$(\"#itemParamAddTable .submit\").click(function(){\n");
      out.write("\t\t\tvar params = [];\n");
      out.write("\t\t\tvar groups = $(\"#itemParamAddTable [name=group]\");\n");
      out.write("\t\t\tgroups.each(function(i,e){\n");
      out.write("\t\t\t\tvar p = $(e).parentsUntil(\"ul\").parent().find(\"[name=param]\");\n");
      out.write("\t\t\t\tvar _ps = [];\n");
      out.write("\t\t\t\tp.each(function(_i,_e){\n");
      out.write("\t\t\t\t\tvar _val = $(_e).siblings(\"input\").val();\n");
      out.write("\t\t\t\t\tif($.trim(_val).length>0){\n");
      out.write("\t\t\t\t\t\t_ps.push(_val);\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t}\n");
      out.write("\t\t\t\t});\n");
      out.write("\t\t\t\tvar _val = $(e).siblings(\"input\").val();\n");
      out.write("\t\t\t\tif($.trim(_val).length>0 && _ps.length > 0){\n");
      out.write("\t\t\t\t\tparams.push({\n");
      out.write("\t\t\t\t\t\t\"group\":_val,\n");
      out.write("\t\t\t\t\t\t\"params\":_ps\n");
      out.write("\t\t\t\t\t});\t\t\t\t\t\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t});\n");
      out.write("\t\t\tvar url = \"/item/param/save/\"+$(\"#itemParamAddTable [name=cid]\").val();\n");
      out.write("\t\t\t$.post(url,{\"paramData\":JSON.stringify(params)},function(data){\n");
      out.write("\t\t\t\tif(data.status == 200){\n");
      out.write("\t\t\t\t\t$.messager.alert('提示','新增商品规格成功!',undefined,function(){\n");
      out.write("\t\t\t\t\t\t$(\".panel-tool-close\").click();\n");
      out.write("    \t\t\t\t\t$(\"#itemParamList\").datagrid(\"reload\");\n");
      out.write("    \t\t\t\t});\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t});\n");
      out.write("\t\t});\n");
      out.write("\t});\n");
      out.write("</script>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
