package hu.unideb.inf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Movies {

    @Id
    @GeneratedValue
    private Integer id;
    private String Title;
    private int LengthHour;
    private int LengthMin;
    private String genre;

    public int getRelease() {
        return release;
    }

    public void setRelease(int release) {
        this.release = release;
    }

    private int release;
    private String About;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public double getLengthHour() {
        return LengthHour;
    }

    public void setLengthHour(int lengthh) {
        this.LengthHour = lengthh;
    }

    public double getLengthMin() {
        return LengthMin;
    }

    public void setLengthMin(int lengthm) {
        this.LengthMin = lengthm;
    }


    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAbout() {
        return About;
    }

    public void setAbout(String about) {
        About = about;
    }

    public static void SetDatabase(){

        try (UserDAO uDAO =new JpaUserDao();){

            //Userek hozzáadása

            User a=new User();
            User b=new User();
            User c=new User();
            User d=new User();

            a.setUserName("Zsollesz");
            a.setPassword("alma123");
            a.setSeensum(3);
            a.setScreentime(10);
            uDAO.saveUser(a);

            b.setUserName("Tomcsa");
            b.setPassword("kukc12");
            b.setSeensum(2);
            b.setScreentime(5);
            uDAO.saveUser(b);

            c.setUserName("Szabesz");
            c.setPassword("helo2342");
            c.setSeensum(3);
            c.setScreentime(7);
            uDAO.saveUser(c);

            d.setUserName("Zollee");
            d.setPassword("anya<3");
            d.setSeensum(1);
            d.setScreentime(3);
            uDAO.saveUser(d);




            Movies mov1 = new Movies();
            Movies mov2 = new Movies();
            Movies mov3 = new Movies();
            Movies mov4 = new Movies();
            Movies mov5 = new Movies();
            Movies mov6 = new Movies();
            Movies mov7 = new Movies();
            Movies mov8 = new Movies();
            Movies mov9 = new Movies();
            Movies mov10 = new Movies();

            mov1.setTitle("The Godfather");
            mov1.setRelease(1972);
            mov1.setGenre("Crime, Drama");
            mov1.setLengthHour(2);
            mov1.setLengthMin(55);
            //mov1.setAbout("A Keresztapa (The Godfather) Mario Puzo azonos című regényéből készült 1972-ben" +
            //        "bemutatott világhírű filmdráma Francis Ford Coppola rendezésében Marlon Brando, Al Pacino," +
            //        "Robert Duvall és James Caan főszereplésével. A film Coppola Keresztapa-trilógiájának első része.");
            uDAO.saveMovie(mov1);

            mov2.setTitle("The Dark Knight");
            mov2.setRelease(2008);
            mov2.setGenre("Action, Crime, Drama");
            mov2.setLengthHour(2);
            mov2.setLengthMin(32);
            //mov2.setAbout("A sötét lovag (The Dark Knight) egy 2008-as amerikai–brit szuperhős-film, amelynek társírója és rendezője Christopher Nolan." +
            //        "A DC Comics képregénykiadó Batman szereplőjén alapuló film a Batman: Kezdődik! (2005) folytatása." +
            //        "A címszerepet ismét Christian Bale alakítja.");
            uDAO.saveMovie(mov2);

            mov3.setTitle("Pulp Fiction");
            mov3.setRelease(1994);
            mov3.setGenre("Crime, Drama");
            mov3.setLengthHour(2);
            mov3.setLengthMin(34);
            //mov3.setAbout("A Ponyvaregény (eredeti cím: Pulp Fiction) 1994-ben bemutatott amerikai bűnügyi film Quentin Tarantino rendezésében." +
            //        "A forgatókönyvet eredetileg Roger Avary írta, Tarantino csak azután kezdte átitatni a számára oly kedves francia új hullámos filmek hangulatával," +
            //        "miután megvette tőle a történet jogát. A film elnyerte az 1994-es cannes-i filmfesztivál fődíját, az Arany Pálmát.");
            uDAO.saveMovie(mov3);

            mov4.setTitle("Star Wars");
            mov4.setRelease(1977);
            mov4.setGenre("Sci-Fi, Fantasy");
            mov4.setLengthHour(2);
            mov4.setLengthMin(1);
            //mov4.setAbout("A Csillagok háborúja (Star Wars) egy amerikai filmfranchise, amit George Lucas filmrendező alkotott meg," +
            //        "és a Lucasfilm gyártja. A filmek cselekménye a „réges-régen, egy messzi-messzi galaxisban…” élő szereplők történetét meséli el." +
            //        "Eredetileg egy 6 részből álló filmsorozat volt (a korábbi filmsorozat 9 részessé vált és Skywalker-saga névre hallgat), de a Csillagok háborúja:" +
            //        "Klónok háborúja filmfranchise-á alakította át.");
            uDAO.saveMovie(mov4);

            mov5.setTitle("Interstellar");
            mov5.setRelease(2014);
            mov5.setGenre("Adventure, Drama, Sci-Fi");
            mov5.setLengthHour(2);
            mov5.setLengthMin(49);
            //mov5.setAbout("A Csillagok között (eredeti cím: Interstellar) 2014-ben bemutatott sci-fi film, amely felvonultatja a" +
            //        "21. századi elméleti fizika elképzeléseit a világűrről, a téridőről, valamint felvázolja a zsákutcába jutott emberiség lehetséges jövőjét." +
            //        "A filmet anamorfikus 35 mm-es és IMAX 70 mm-es filmre fényképezték, zenéjét Hans Zimmer készítette, rendezője Christopher Nolan.");
            uDAO.saveMovie(mov5);

            mov6.setTitle("Joker");
            mov6.setRelease(2019);
            mov6.setGenre("Crime, Drama, Thriller");
            mov6.setLengthHour(2);
            mov6.setLengthMin(2);
            //mov6.setAbout("A Joker 2019-ben bemutatott amerikai filmdráma, pszichológiai thriller Todd Phillips rendezésében." +
            //        "A forgatókönyvet Todd Phillips és Scott Silver írta, producerei Todd Phillips, Bradley Cooper és Emma Tillinger Koskoff." +
            //        "A főszerepekben Joaquin Phoenix, Robert De Niro, Zazie Beetz, Frances Conroy és Brett Cullen láthatók. A film zeneszerzője Hildur Guðnadóttir." +
            //        "A film gyártója a DC Filmes, a Village Roadshow Pictures, a Bron Creative és a Joint Effort, forgalmazója a Warner Bros. Pictures.");
            uDAO.saveMovie(mov6);

            mov7.setTitle("The Lord of the Rings: The Fellowship of the Ring");
            mov7.setRelease(2001);
            mov7.setGenre("Action, Adventure, Drama");
            mov7.setLengthHour(2);
            mov7.setLengthMin(58);
            //mov7.setAbout("A Gyűrűk Ura: A Gyűrű Szövetsége (eredeti cím: The Lord of the Rings: The Fellowship of the Ring) 2001-ben bemutatott négyszeres" +
            //        "Oscar-díjas új-zélandi–amerikai fantasyfilm Peter Jackson rendezésében.A film J. R. R. Tolkien azonos című epikus fantasy-regényén alapuló" +
            //        "A Gyűrűk Ura-filmsorozat első darabja.");
            uDAO.saveMovie(mov7);

            mov8.setTitle("Scarface");
            mov8.setRelease(1983);
            mov8.setGenre("Crime, Drama");
            mov8.setLengthHour(2);
            mov8.setLengthMin(50);
            //mov8.setAbout("A sebhelyesarcú[4] (Scarface) 1983-ban bemutatott amerikai gengszterfilm, melyet Brian De Palma rendezett, a forgatókönyvíró" +
            //        "a később rendezővé váló Oliver Stone volt. A film az 1932-es, azonos című Howard Hawks-produkció remake-je,az Al Pacino által életre" +
            //        "keltett Tony Montana alakját Al Capone karaktere ihlette.");
            uDAO.saveMovie(mov8);

            mov9.setTitle("The Wolf of Wall Street");
            mov9.setRelease(2013);
            mov9.setGenre("Biography, Comedy, Crime");
            mov9.setLengthHour(3);
            mov9.setLengthMin(0);
            //mov9.setAbout("A Wall Street farkasa (eredeti cím: The Wolf of Wall Street) egy 2013-ban bemutatott amerikai önéletrajzi filmdráma," +
            //        "melyet az Oscar-díjas Martin Scorsese rendezett. A címszereplőt Leonardo DiCaprio személyesíti meg.");
            uDAO.saveMovie(mov9);

            mov10.setTitle("Matrix");
            mov10.setRelease(1999);
            mov10.setGenre("Sci-Fi, Action");
            mov10.setLengthHour(2);
            mov10.setLengthMin(16);
            //mov10.setAbout("A Mátrix (eredeti cím: The Matrix) 1999-ben bemutatott amerikai–ausztrál koprodukcióban készült sci-fi" +
            //        "film Lana és Lilly Wachowski írásában és rendezésében, Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss, Joe Pantoliano" +
            //        "és Hugo Weaving főszereplésével.");
            uDAO.saveMovie(mov10);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
