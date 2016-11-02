package com.cdkj.service.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SCDM_IDAO {

    private static String key = "fieldTimes";

    private static String packge = "com.std.user.";

    private static String dbname = "tstd_field_times";

    private static String[] DBwords = { "id", "type", "user_id", "times" };

    private static String[] DOwords = getDOwords();

    private static String Key = key.substring(0, 1).toUpperCase()
            + key.substring(1);

    public static void main(String[] args) {

        File DOMAINfile = new File("/Users/xieyj/Desktop/temp", Key + ".java");

        File Mapperfile = new File("/Users/xieyj/Desktop/temp", Key
                + "Mapper.xml");

        File IDAOfile = new File("/Users/xieyj/Desktop/temp", "I" + Key
                + "DAO.java");

        File DAOImplfile = new File("/Users/xieyj/Desktop/temp", Key
                + "DAOImpl.java");

        File IBOfile = new File("/Users/xieyj/Desktop/temp", "I" + Key
                + "BO.java");

        File BOImplfile = new File("/Users/xieyj/Desktop/temp", Key
                + "BOImpl.java");

        File IAOfile = new File("/Users/xieyj/Desktop/temp", "I" + Key
                + "AO.java");

        File AOImplfile = new File("/Users/xieyj/Desktop/temp", Key
                + "AOImpl.java");
        try {
            DOMAINfile.createNewFile(); // ����domian�ļ�

            Mapperfile.createNewFile(); // ����Mapper�ļ�

            IDAOfile.createNewFile(); // ����IDAO�ļ�

            DAOImplfile.createNewFile(); // ����DAOImpl�ļ�

            IBOfile.createNewFile(); // ����IBO�ļ�

            BOImplfile.createNewFile(); // ����BOImpl�ļ�

            IAOfile.createNewFile(); // ����IAO�ļ�

            AOImplfile.createNewFile(); // ����AOImpl�ļ�
        } catch (IOException e) {
            e.printStackTrace();
        }

        String DOMAIN = getDOMAIN();
        byte DOMAINbt[] = new byte[1024];
        DOMAINbt = DOMAIN.getBytes();

        String Mapper = getMapper();
        byte Mapperbt[] = new byte[1024];
        Mapperbt = Mapper.getBytes();

        String IDAO = getIDAO();
        byte IDAObt[] = new byte[1024];
        IDAObt = IDAO.getBytes();

        String DAOImpl = getDAOImpl();
        byte DAOImplbt[] = new byte[1024];
        DAOImplbt = DAOImpl.getBytes();

        String IBO = getIBO();
        byte IBObt[] = new byte[1024];
        IBObt = IBO.getBytes();

        String BOImpl = getBOImpl();
        byte BOImplbt[] = new byte[1024];
        BOImplbt = BOImpl.getBytes();

        String IAO = getIAO();
        byte IAObt[] = new byte[1024];
        IAObt = IAO.getBytes();

        String AOImpl = getAOImpl();
        byte AOImplbt[] = new byte[1024];
        AOImplbt = AOImpl.getBytes();
        try {
            FileOutputStream DOMAINin = new FileOutputStream(DOMAINfile);

            FileOutputStream Mapperin = new FileOutputStream(Mapperfile);

            FileOutputStream IDAOin = new FileOutputStream(IDAOfile);

            FileOutputStream DAOImplin = new FileOutputStream(DAOImplfile);

            FileOutputStream IBOin = new FileOutputStream(IBOfile);

            FileOutputStream BOImplin = new FileOutputStream(BOImplfile);

            FileOutputStream IAOin = new FileOutputStream(IAOfile);

            FileOutputStream AOImplin = new FileOutputStream(AOImplfile);
            try {
                DOMAINin.write(DOMAINbt, 0, DOMAINbt.length);
                DOMAINin.close();

                Mapperin.write(Mapperbt, 0, Mapperbt.length);
                Mapperin.close();

                IDAOin.write(IDAObt, 0, IDAObt.length);
                IDAOin.close();

                DAOImplin.write(DAOImplbt, 0, DAOImplbt.length);
                DAOImplin.close();

                IBOin.write(IBObt, 0, IBObt.length);
                IBOin.close();

                BOImplin.write(BOImplbt, 0, BOImplbt.length);
                BOImplin.close();

                IAOin.write(IAObt, 0, IAObt.length);
                IAOin.close();

                AOImplin.write(AOImplbt, 0, AOImplbt.length);
                AOImplin.close();
                // boolean success=true;
                // System.out.println("д���ļ��ɹ�");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static String[] getDOwords() {
        String[] DOwords = new String[DBwords.length];
        String word = "";
        for (int i = 0; i < DBwords.length; i++) {
            word = "";
            if (DBwords[i].contains("_")) {
                String[] words = DBwords[i].split("_");
                for (int j = 0; j < words.length; j++) {
                    if (j == 0) {
                        word += words[j];
                    } else {
                        word += words[j].substring(0, 1).toUpperCase()
                                + words[j].substring(1);
                    }
                }
                DOwords[i] = word;
            } else {
                DOwords[i] = DBwords[i];
            }
        }
        return DOwords;
    }

    private static String getDOMAIN() {
        String str = "";
        String str1 = "package " + packge + "domain;\n\n" + "import " + packge
                + "dao.base.ABaseDO;\n\n" + "//CHECK ��鲢��ע�� \n"
                + "public class " + Key + " extends ABaseDO {" + "\n\n\t"
                + "private static final long serialVersionUID = 1L;" + "\n\n\t";
        String str2 = "";
        for (int i = 0; i < DOwords.length; i++) {
            if (i < DOwords.length - 1) {
                str2 += "private String " + DOwords[i] + ";\n\n\t";
            } else {
                str2 += "private String " + DOwords[i] + ";\n\n";
            }
        }
        str2 += "}";
        str = str1 + str2;
        return str;
    }

    private static String getMapper() {
        String str = "";
        String str1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                + "<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\"\n"
                + "\"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\n"
                + "<mapper namespace=\"" + packge + "dao.I" + Key
                + "DAO\">\n\t" + "<resultMap id=\"" + key
                + "_DB_Result\" type=\"" + key + "\">\n\t\t";

        String str2 = "";
        for (int i = 0; i < DBwords.length; i++) {
            if (i < DBwords.length - 1) {
                str2 += "<result column=\"" + DBwords[i] + "\" property=\""
                        + DOwords[i] + "\" />\n\t\t";
            } else {
                str2 += "<result column=\"" + DBwords[i] + "\" property=\""
                        + DOwords[i] + "\" />\n\t";
            }
        }
        str2 += "</resultMap>\n\t"
                + "<sql id=\"where_condition\">\n\t\t"
                + "<trim prefix=\"WHERE\" prefixOverrides=\"AND | OR\">\n\t\t\t"
                + "<if test=\"code != null and code != '' \">\n\t\t\t\t"
                + "AND t.code = #{code}\n\t\t\t"
                + "</if>\n\t\t</trim>\n\t</sql>\n\t";

        str2 += "<select id=\"select_" + key + "\" parameterType=\"" + key
                + "\" resultMap=\"" + key + "_DB_Result\">\n\t\t"
                + "SELECT\n\t\t";

        String str3 = "";
        for (int i = 0; i < DBwords.length; i++) {
            if (i == 0) {
                str3 += "t." + DBwords[i] + "\n\t\t";
            } else {
                str3 += ",t." + DBwords[i] + "\n\t\t";
            }
        }
        str3 += "FROM\n\t\t" + dbname + " t\n\t\t"
                + "<include refid=\"where_condition\" />\n\t\t"
                + "<trim prefix=\"ORDER BY \">\n\t\t\t"
                + "<if test=\"order != null and order != '' \">\n\t\t\t\t"
                + "t.${order}\n\t\t\t</if>\n\t\t</trim>\n\t</select>\n\n";

        str3 += "\t<select id=\"select_" + key + "_count\" parameterType=\""
                + key + "\"\n\t\t" + "resultType=\"java.lang.Long\">\n\t\t"
                + "SELECT count(1) FROM " + dbname + " t\n\t\t"
                + "<include refid=\"where_condition\" />\n\t</select>\n\n";

        str3 += "\t<insert id=\"insert_" + key + "\" parameterType=\"" + key
                + "\">\n\t\tINSERT INTO\n\t\t" + dbname + "(\n\t\t";

        String str4 = "";
        for (int i = 0; i < DBwords.length; i++) {
            if (i == 0) {
                str4 += DBwords[i] + "\n\t\t";
            } else {
                str4 += "," + DBwords[i] + "\n\t\t";
            }
        }
        str4 += ")\n\t\tVALUES(\n\t\t";

        String str5 = "";
        for (int i = 0; i < DOwords.length; i++) {
            if (i == 0) {
                str5 += "#{" + DOwords[i] + "}\n\t\t";
            } else {
                str5 += ",#{" + DOwords[i] + "}\n\t\t";
            }
        }
        str5 += ")\n\t</insert>\n\n\t" + "<update id=\"update_" + key
                + "\" parameterType=\"" + key + "\">\n\t\t" + "UPDATE "
                + dbname + "\n\t\tSET\n\t\t";

        String str6 = "";
        for (int i = 1; i < DBwords.length; i++) {
            if (i == 1) {
                str6 += DBwords[i] + " = #{" + DOwords[i] + "}\n\t\t";
            } else {
                str6 += "," + DBwords[i] + " = #{" + DOwords[i] + "}\n\t\t";
            }
        }
        str6 += "WHERE code = #{code}\n\t</update>\n\n\n</mapper>";
        str = str1 + str2 + str3 + str4 + str5 + str6;
        return str;
    }

    private static String getIDAO() {
        String str = "package " + packge + "dao;\n\n" + "import " + packge
                + "dao.base.IBaseDAO;\n" + "import " + packge + "domain." + Key
                + ";\n\n" + "//CHECK ��鲢��ע�� \n" + "public interface I" + Key
                + "DAO extends IBaseDAO<" + Key + "> {" + "\n\t"
                + "String NAMESPACE = I" + Key
                + "DAO.class.getName().concat(\".\");" + "\n" + "}";
        return str;
    }

    private static String getDAOImpl() {
        String str = "package " + packge + "dao.impl;\n\n"
                + "import java.util.List;\n\n"
                + "import org.springframework.stereotype.Repository;\n\n"
                + "import " + packge + "dao.I" + Key + "DAO;\n" + "import "
                + packge + "dao.base.support.AMybatisTemplate;\n" + "import "
                + packge + "domain." + Key + ";\n\n\n\n"
                + "//CHECK ��鲢��ע�� \n" + "@Repository(\"" + key
                + "DAOImpl\")\n" + "public class " + Key
                + "DAOImpl extends AMybatisTemplate implements I" + Key
                + "DAO {\n\n\n\t" + "@Override\n\tpublic int insert(" + Key
                + " data) {\n\t\t"
                + "return super.insert(NAMESPACE.concat(\"insert_" + key
                + "\"), data);\n\t}\n\n\n\t"
                + "@Override\n\tpublic int delete(" + Key + " data) {\n\t\t"
                + "return super.delete(NAMESPACE.concat(\"delete_" + key
                + "\"), data);\n\t}\n\n\n\t" + "@Override\n\tpublic " + Key
                + " select(" + Key + " condition) {\n\t\t"
                + "return super.select(NAMESPACE.concat(\"select_" + key
                + "\"), condition," + Key + ".class);\n\t}\n\n\n\t"
                + "@Override\n\tpublic Long selectTotalCount(" + Key
                + " condition) {\n\t\t"
                + "return super.selectTotalCount(NAMESPACE.concat(\"select_"
                + key + "_count\"),condition);\n\t}\n\n\n\t"
                + "@Override\n\tpublic List<" + Key + "> selectList(" + Key
                + " condition) {\n\t\t"
                + "return super.selectList(NAMESPACE.concat(\"select_" + key
                + "\"), condition," + Key + ".class);\n\t}\n\n\n\t"
                + "@Override\n\tpublic List<" + Key + "> selectList(" + Key
                + " condition, int start, int count) {\n\t\t"
                + "return super.selectList(NAMESPACE.concat(\"select_" + key
                + "\"), start, count,condition, " + Key
                + ".class);\n\t}\n\n\n}";
        return str;
    }

    private static String getIBO() {
        String str = "package " + packge + "bo;\n\n"
                + "import java.util.List;\n\n" + "import " + packge
                + "bo.base.IPaginableBO;\n" + "import " + packge + "domain."
                + Key + ";\n\n\n\n" + "//CHECK ��鲢��ע�� \n"
                + "public interface I" + Key + "BO extends IPaginableBO<" + Key
                + "> {\n\n\n\t" + "public boolean is" + Key
                + "Exist(String code);\n\n\n\t" + "public String save" + Key
                + "(" + Key + " data);\n\n\n\t" + "public int remove" + Key
                + "(String code);\n\n\n\t" + "public int refresh" + Key + "("
                + Key + " data);\n\n\n\t" + "public List<" + Key + "> query"
                + Key + "List(" + Key + " condition);\n\n\n\t" + "public "
                + Key + " get" + Key + "(String code);\n\n\n}";
        return str;
    }

    public static String getBOImpl() {
        String str = "package "
                + packge
                + "bo.impl;\n\n"
                + "import java.util.List;\n\n"
                + "import org.apache.commons.collections.CollectionUtils;\n"
                + "import org.apache.commons.lang3.StringUtils;\n"
                + "import org.springframework.beans.factory.annotation.Autowired;\n"
                + "import org.springframework.stereotype.Component;\n\n"
                + "import "
                + packge
                + "bo.I"
                + Key
                + "BO;\n"
                + "import "
                + packge
                + "bo.base.PaginableBOImpl;\n"
                + "import "
                + packge
                + "core.EGeneratePrefix;\n"
                + "import "
                + packge
                + "core.OrderNoGenerater;\n"
                + "import "
                + packge
                + "dao.I"
                + Key
                + "DAO;\n"
                + "import "
                + packge
                + "domain."
                + Key
                + ";\n"
                + "import "
                + packge
                + "exception.BizException;\n\n\n\n"
                + "//CHECK ��鲢��ע�� \n@Component\n"
                + "public class "
                + Key
                + "BOImpl extends PaginableBOImpl<"
                + Key
                + "> implements I"
                + Key
                + "BO {\n\n\t"
                + "@Autowired\n\tprivate I"
                + Key
                + "DAO "
                + key
                + "DAO;\n\n\t"
                + "@Override\n\tpublic boolean is"
                + Key
                + "Exist(String code) {\n\t\t"
                + ""
                + Key
                + " condition = new "
                + Key
                + "();\n\t\tcondition.setCode(code);\n\t\t"
                + "if ("
                + key
                + "DAO.selectTotalCount(condition) > 0) {\n\t\t\treturn true;\n\t\t}\n\t\t"
                + "return false;\n\t}\n\n\t@Override\n\t"
                + "public String save"
                + Key
                + "("
                + Key
                + " data) {\n\t\tString code = null;\n\t\t"
                + "if (data != null) {\n\t\t\t"
                + "code = OrderNoGenerater.generateM(EGeneratePrefix.CT.getCode());\n\t\t\t"
                + "data.setCode(code);\n\t\t\t"
                + key
                + "DAO.insert(data);\n\t\t}\n\t\treturn code;\n\t}\n\n\t"
                + "@Override\n\tpublic int remove"
                + Key
                + "(String code) {\n\t\t"
                + "int count = 0;\n\t\tif (StringUtils.isNotBlank(code)) {\n\t\t\t"
                + ""
                + Key
                + " data = new "
                + Key
                + "();\n\t\t\tdata.setCode(code);\n\t\t\tcount = "
                + key
                + "DAO.delete(data);\n\t\t}"
                + "\n\t\treturn count;\n\t}\n\n\t@Override\n\t"
                + "public int refresh"
                + Key
                + "("
                + Key
                + " data) {\n\t\t"
                + "int count = 0;\n\t\tif (StringUtils.isNotBlank(data.getCode())) {\n\t\t\t"
                + "count = "
                + key
                + "DAO.update(data);\n\t\t}\n\t\treturn count;\n\t}\n\n\t"
                + "@Override\n\tpublic List<"
                + Key
                + "> query"
                + Key
                + "List("
                + Key
                + " condition) {\n\t\t"
                + "return "
                + key
                + "DAO.selectList(condition);\n\t}\n\n\t"
                + "@Override\n\tpublic "
                + Key
                + " get"
                + Key
                + "(String code) {\n\t\t"
                + ""
                + Key
                + " data = null;\n\t\tif (StringUtils.isNotBlank(code)) {\n\t\t\t"
                + ""
                + Key
                + " condition = new "
                + Key
                + "();\n\t\t\tcondition.setCode(code);\n\t\t\t"
                + "data = "
                + key
                + "DAO.select(condition);\n\t\t\tif (data == null) {\n\t\t\t\t"
                + "throw new BizException(\"xn0000\", \"�� ��Ų�����\");\n\t\t\t"
                + "}\n\t\t}\n\t\treturn data;\n\t}\n}";
        return str;
    }

    private static String getIAO() {
        String str = "package "
                + packge
                + "ao;\n\n"
                + "import java.util.List;\n\n"
                + "import "
                + packge
                + "bo.base.Paginable;\n"
                + "import "
                + packge
                + "domain."
                + Key
                + ";\n\n\n\n"
                + "//CHECK ��鲢��ע�� \n@Component\n"
                + "public interface I"
                + Key
                + "AO {\n\t"
                + "static final String DEFAULT_ORDER_COLUMN = \"code\";\n\n\n\t"
                + "public String add" + Key + "(" + Key + " data);\n\n\t"
                + "public int drop" + Key + "(String code);\n\n\t"
                + "public int edit" + Key + "(" + Key + " data);\n\n\t"
                + "public Paginable<" + Key + "> query" + Key
                + "Page(int start, int limit, " + Key + " condition);\n\n\t"
                + "public List<" + Key + "> query" + Key + "List(" + Key
                + " condition);\n\n\t" + "public " + Key + " get" + Key
                + "(String code);\n\n}";
        return str;
    }

    private static String getAOImpl() {
        String str = "package "
                + packge
                + "ao.impl;\n\n"
                + "import java.util.List;\n\n"
                + "import org.springframework.beans.factory.annotation.Autowired;\n"
                + "import org.springframework.stereotype.Service;\n\n"
                + "import " + packge + "ao.I" + Key + "AO;\n" + "import "
                + packge + "bo.I" + Key + "BO;\n" + "import " + packge
                + "bo.base.Paginable;\n" + "import " + packge + "domain." + Key
                + ";\n" + "import " + packge
                + "exception.BizException;\n\n\n\n"
                + "//CHECK ��鲢��ע�� \n@Component\n@Service\n" + "public class "
                + Key + "AOImpl implements I" + Key + "AO {\n\n\t"
                + "@Autowired\n\tprivate I" + Key + "BO " + key + "BO;\n\n\t"
                + "@Override\n\tpublic String add" + Key + "(" + Key
                + " data) {\n\t\t" + "return " + key + "BO.save" + Key
                + "(data);\n\t}\n\n\t" + "@Override\n\tpublic int edit" + Key
                + "(" + Key + " data) {\n\t\t" + "if (!" + key + "BO.is" + Key
                + "Exist(data.getCode())) {\n\t\t\t"
                + "throw new BizException(\"xn0000\", \"�ñ�Ų�����\");\n\t\t"
                + "}\n\t\treturn " + key + "BO.refresh" + Key
                + "(data);\n\t}\n\n\t" + "@Override\n\tpublic int drop" + Key
                + "(String code) {\n\t\t" + "if (!" + key + "BO.is" + Key
                + "Exist(code)) {\n\t\t\t"
                + "throw new BizException(\"xn0000\", \"�ñ�Ų�����\");\n\t\t"
                + "}\n\t\treturn " + key + "BO.remove" + Key
                + "(code);\n\t}\n\n\t" + "@Override\n\tpublic Paginable<" + Key
                + "> query" + Key + "Page(int start, int limit,\n\t\t\t" + ""
                + Key + " condition) {\n\t\t" + "return " + key
                + "BO.getPaginable(start, limit, condition);\n\t"
                + "}\n\n\t@Override\n\t" + "public List<" + Key + "> query"
                + Key + "List(" + Key + " condition) {\n\t\t" + "return " + key
                + "BO.query" + Key + "List(condition);\n\t}\n\n\t"
                + "@Override\n\tpublic " + Key + " get" + Key
                + "(String code) {\n\t\t" + "return " + key + "BO.get" + Key
                + "(code);\n\t}\n}";
        return str;
    }
}
