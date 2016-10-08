package by.it.artiuschik.jd_01_09.mathlab.utils;

import by.it.artiuschik.jd_01_09.mathlab.utils.Patterns;
import by.it.artiuschik.jd_01_09.mathlab.vars.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    //Возвращает операнды и знак
    public static List<Object> ParseFromString(String str)
    {
        List<Object> list=new ArrayList(2);
        List<Object> vars=new ArrayList();//операнды
        Pattern p=Pattern.compile(Patterns.any);
        Matcher m=p.matcher(str);
        while(m.find())
        {
            if(Pattern.matches(Patterns.number,m.group()))
            {
                vars.add(new VarF(m.group()));
            }
            if(Pattern.matches(Patterns.vector,m.group()))
            {
                vars.add(new VarV(m.group()));
            }
            if(Pattern.matches(Patterns.matrix,m.group()))
            {
                vars.add(new VarM(m.group()));
            }
            if(Pattern.matches(Patterns.varName,m.group()))
            {
                vars.add(new String(m.group()));
            }
            if(Pattern.matches(Patterns.oper,m.group()))
            {
                list.add(new String(m.group()));
            }
        }
        list.add(vars);
        return list;
    }
}
