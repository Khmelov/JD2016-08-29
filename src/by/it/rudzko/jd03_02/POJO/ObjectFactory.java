package by.it.rudzko.jd03_02.POJO;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import java.util.List;

@XmlRegistry
public class ObjectFactory {

    private final static QName _MyDataBase_QNAME = new QName("http://POJO.jd03_02.rudzko.it.by/", "myDataBase");

    public ObjectFactory() {}

    MyDataBase createMyDataBase(Users us, Roles roles, Periodicals p, Readership aud, Subscription sub) {
        MyDataBase result = new MyDataBase();
        result.setUsers(us);
        result.setRoles(roles);
        result.setPeriodicals(p);
        result.setReadership(aud);
        result.setSubscription(sub);
        return result;
    }

    public User createUser(String name, Role role, int birthYear, String sex) {
        User user = new User();
        user.setName(name);
        user.setRole(role);
        user.setBirthYear(birthYear);
        user.setSex(sex);
        return user;
    }

    Readership createReadership(List<Audience> audience) {
        Readership res = new Readership();
        res.setAudience(audience);
        return res;
    }

    public Subscr createSubscr(User user, Periodical periodical) {
        Subscr result = new Subscr();
        result.setSubscriber(user);
        result.setPeriodical(periodical);
        return result;
    }

    public Audience createAudience(String group) {
        Audience aud = new Audience();
        aud.setGroup(group);
        return aud;
    }

    public Periodical createPeriodical(String title, int subIndex, Audience aud, User addedBy) {
        Periodical p = new Periodical();
        p.setTitle(title);
        p.setSubIndex(subIndex);
        p.setAudience(aud);
        p.setAddedBy(addedBy);
        return p;
    }

    Roles createRoles(List<Role> role) {
        Roles r = new Roles();
        r.setRoles(role);
        return r;
    }

    Users createUsers(List<User> user) {
        Users u = new Users();
        u.setUsers(user);
        return u;
    }

    public Role createRole(String participant) {
        Role r = new Role();
        r.setParticipant(participant);
        return r;
    }

    Periodicals createPeriodicals(List<Periodical> periodical) {
        Periodicals p = new Periodicals();
        p.setPeriodicals(periodical);
        return p;
    }

    Subscription createSubscription(List<Subscr> subscr) {
        Subscription sub = new Subscription();
        sub.setSubscr(subscr);
        return sub;
    }

    @XmlElementDecl(namespace = "http://POJO.jd03_02.rudzko.it.by/", name = "myDataBase")
    public JAXBElement<MyDataBase> createMyDataBase(MyDataBase value) {
        return new JAXBElement<>(_MyDataBase_QNAME, MyDataBase.class, null, value);
    }

}
