package pkgTp;
import java.util.Random;
import java.util.Scanner;
public class tp2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        int y = 1;
        while (y == 1) {
            //Une boucle pour ne pas arrêter le programme après une méthode.
            int choix=0;
            int choix2=0;//choix 1 et 2 pour les menus
            choix=choix1(choix);
            if (choix == 3) {
                System.out.println("Compris.");
                y = 2;
                //Pour sortir de la boucle, il faut briser la condition de y=1.
                break;
                //break de la boucle parce que sinon le programme continue.
            }
            choix2=choix_2(choix2);//une confirmation de ce choix
            if (choix == 1) {//lire c'est quoi
                if (choix2 == 5) {//choisir avec random
                    choix2 = rnd.nextInt(4)+1;
                }
                switch (choix2) {//le programme
                    case 1:
                        char[] let_1 = new char[0];//création du tableau
                        let_1=rot_13(let_1);//appel à la méthode
                        message_décrypté(let_1);//afficher le message décrypté
                        //le message décodé
                        break;
                    case 2:
                        char[] cesar1 = new char[0];//la même chose mais avec les autres choix
                        cesar1=c_cesar(cesar1);
                        message_décrypté(cesar1);
                        break;
                    case 3:
                        char[] c3d = new char[0];
                        c3d=cesar3d(c3d);
                        message_décrypté(c3d);
                        break;
                    default: char [] P_A=new char[0];
                    Poly_Alphavariante(P_A);//Je ne peux pas afficher le P_A ici vu que je ne peux pas retourner deux tableaux (alt et P_A), et le programme ne va pas marcher.
                }
            }
            if (choix == 2) {//le choix 2 s'agit du random et le choix 1 est de saisir au clavier.
                if (choix2 == 5) {
                    choix2 = rnd.nextInt(4)+1;
                }
                switch (choix2) {
                    case 1:
                        char[] rot_13_rnd = new char[0];
                        rot_13_rnd=rot_13_random(rot_13_rnd);
                        rot_message_random(rot_13_rnd);
                        //message décrypté
                        break;
                    case 2:
                        char[] cesar_rnd = new char[0];
                        cesar_rnd=c_cesar_rnd(cesar_rnd);
                        rot_message_random(cesar_rnd);
        /*J'ai gardé le nom rot pour me rappeler que c'est l'affichage du random,
        mais il est utilisé pour tous les random et pas juste pour rot.
        */
                        break;
                    case 3:char [] random_cesar=new char[0];
                    random_cesar=cesarRND(random_cesar);
                    rot_message_random(random_cesar);
                        break;
                    default: char [] P_R=new char[0];
                    PA_RND(P_R);

                }
            }
        }
    }

    public static int choix1 (int q){//validation du choix 1 et etc.
        Scanner sc=new Scanner(System.in);
        int choix;
        //variable pour les choix des menus
        menu_1();
        //afficher le menu 1
        choix = sc.nextInt();
        while (choix < 1 || choix > 3) {
            System.out.println("Veuillez saisir un option valide");
            choix = sc.nextInt();
            //Si le choix n'est pas valide.
        }
        int confirmation;
        confirmer(choix);
        confirmation = sc.nextInt();
        //Pour lire directement la confirmation
        while (confirmation < 1 || confirmation > 2) {
            System.out.println("Veuillez choisir un option valide");
            confirmation=sc.nextInt();
        }
        if (confirmation == 2) {
            System.out.println("Ok. Saisissez votre choix de nouveau:");
            choix = sc.nextInt();
            while (choix < 1 || choix > 3) {
                System.out.println("Veuillez saisir un option valide");
                choix = sc.nextInt();
            }
        }
        return choix;
    }
    public static int choix_2 (int q){
        Scanner sc=new Scanner(System.in);
        int choix2;
        int confirmation;
        menu_2();
        //afficher le deuxième menu.
        choix2 = sc.nextInt();
        while (choix2 < 1 || choix2 > 5) {
            System.out.println("Veuillez saisir un option valide");
            choix2 = sc.nextInt();
        }
        confirmer(choix2);
        confirmation = sc.nextInt();
        while (confirmation < 1 || confirmation > 2) {
            System.out.println("Veuillez choisir un option valide");
            confirmation=sc.nextInt();
        }
        if (confirmation == 2) {
            System.out.println("Ok. Saisissez votre choix de nouveau:");
            choix2 = sc.nextInt();
            while (choix2 < 1 || choix2 > 5) {
                System.out.println("Veuillez saisir un option valide");
                choix2 = sc.nextInt();
            }
        }
        return choix2;
    }
    public static void confirmer(int i) {
        Scanner sc = new Scanner(System.in);
        int choix;
        System.out.println("Vous avez choisi: le choix " + i);
        //le i est le choix en question (en chiffre)
        System.out.println("Est-ce bien ça?");
        System.out.println("1- Oui");
        System.out.println("2- Non");
        //confirmation pour le programme
    }

    public static void menu_1() {
        System.out.println("+ +++++++++++++++++++++++++++++++++++++++ +");
        System.out.println("+ Faites votre choix:                     +");
        System.out.println("+ 1- Je veux saisir le message au clavier +");
        System.out.println("+ 2- Je veux le générer avec Random       +");
        System.out.println("+ 3- Je veux aller dormir. (Quitter)      +");
        System.out.println("+ +++++++++++++++++++++++++++++++++++++++ +");
    }

    public static void menu_2() {
        System.out.println("==========================================");
        System.out.println("= Je choisis:                            =");
        System.out.println("= 1- Le ROT-13 (décalage)                =");
        System.out.println("= 2- Le chiffre de César                 =");
        System.out.println("= 3- César au choix                      =");
        System.out.println("= 4- Le poly-alphavariante               =");
        System.out.println("= 5- Je ne sais pas, choisissez pour moi =");
        System.out.println("==========================================");
    }

    public static char[] rot_13(char[] let_1) {
        Scanner sc = new Scanner(System.in);
        String let = "rien";
        //initialiser le string
        System.out.println("Rot-13:");
        System.out.println("Saisissez le code: (pressez 'enter' deux fois)");//à cause du sc.nextLine, appuyer une fois ne marche pas.
        let = sc.nextLine();
        sc.nextLine();
        //vider le tampon
        let_1=let.toCharArray();//convertir en tableau
        let_1=confirmer3(let,let_1);
        //le tableau dans confirmer3 est transmis à let_1 parce que je ne peux utiliser qu'un tableau.
        message_crypté(let_1);/*afficher le message original. Je ne peux pas l'utiliser dans main vu qu'il est déjà transformé après alt et je ne peux pas utiliser le String au cas
        ou le code est changé.
        */
        let_1=alt(let_1,13,13,'a','m','n','z');//voir la méthode alt pour les explications
        //donc, j'ai remplacé let_1 par alt pour avoir le tableau décodé.
        return let_1;//retourner le tableau pour afficher le message décrypté.

    }

    public static char [] alt (char [] a, int d_plus,int d_moins, char debut1, char fin1,char debut2, char fin2){//char a s'agit du tableau
        for (int i = 0; i <= a.length - 1; i++) {
            if (a[i] >= debut1 && a[i] <= fin1||a[i]>=Character.toUpperCase(debut1)&&a[i]<=Character.toUpperCase(fin1)) {//du char début au char fin (et les majuscules aussi)
                a[i] = a[i] += d_plus;//d_plus est le chiffre du décalage
            }
            /*exemple: de (debut1) a à (fin1) m, ajouter (d_plus)13: C'est le rot-13 (if (let_1[i]>='a' && let_1[i]<='m'||let_1[i]>='A'&& let_1[i]<='M'){)
            (let_1[i]=let_1[i]+=13;})
            */
            //le += permet d'éviter le (char) donc je l'ai mis.
            else if (a[i] == ' ') {
// pour ne pas transformer les espaces aussi
            }
            else if (a[i] >= debut2 && a[i] <= fin2||a[i]>=Character.toUpperCase(debut2)&&a[i]<=Character.toUpperCase(fin2)) {
                //J'ai ajouté un if au cas ou les charactères saisis auront des choses bizarres comme % ou $
                a[i] = a[i] -= d_moins;
                //C'est une soustraction puisque l'addition va les transformer en charactères bizarres.
            }/*Je n'ai pas mis juste else mais else if parce que ça se peut qu'il y a un charactère
            qui n'est pas une lettre (&,* ou %). Dans cette situation, il doit etre laissé tel quel.
             */
        }
        return a; //retourner le tableau.
    }
    public static void confirmer2(String q) {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+ Votre code est: " + q + ". Voulez vous le changer?  +");
        System.out.println("+ 1- Non                                          +");
        System.out.println("+ 2- Oui                                          +");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
        //Juste un menu. Confirmation du code à déchiffrer.
    }
    public static char[] confirmer3 (String a, char [] b){//confirmation du code saisi et remplacement s'il y a eu un erreur de frappe.
        confirmer2(a);//le menu en dessus est mis ici
        Scanner sc=new Scanner(System.in);
        int choix;
        choix = sc.nextInt();
        while (choix < 1 || choix > 2) {
            System.out.println("Veuillez faire un choix valide.");
            choix = sc.nextInt();
        }
        if (choix == 2) { //si le code n'était pas bon
            System.out.println("Saisissez le code: (pressez 'enter' deux fois)");
            sc.nextLine();
            a=sc.nextLine();
            sc.nextLine();//J'ai vidé le tampon 2 fois parce que sinon les lettres ne s'enregistraient pas.
            b=a.toCharArray();
            // le même programme
        }
        return b;
    }


    public static void message_crypté(char [] b) {//affichage du message crypté
        System.out.println();//saut d'une ligne
        System.out.print("Voici le message crypté:");/*J'ai utilisé print pour que le code
        soit à la meme ligne que ce message
        */
        for (int i=0; i<=b.length-1; i++){
            System.out.print(b[i]);
        }
        System.out.println();//saut d'une ligne
    }

    public static void message_décrypté(char[] a2) {
        System.out.print("Voici le message décrypté: ");
        for (int r = 0; r <= a2.length - 1; r++) {
            System.out.print(a2[r]);
        }
        System.out.println();
    }

    public static char [] rot_13_random(char[] rot_13_rnd) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Rot-13 random:");
        rot_13_rnd=generer(rot_13_rnd,26,'a');//méthode pour générer un random
        //puis enregistrer le tableau retourné dans rot_13_rnd que je vais utiliser.
        rot_13_rnd=C4(rot_13_rnd,26,'a');//confirmation du message
        //méthode pour confirmer le code random et placer le nouveau (s'il a eu lieu) dans l'ancien variable.
        rot_13_rnd=alt(rot_13_rnd,13,13,'a','m','n','z');
       return rot_13_rnd;//la même chose que rot-13, mais je ne convertis plus le String en char tab vu que je peux directerment générer un tab.

    }
    public static char [] generer (char [] a, int bound, char b){
        Random rnd = new Random();
        int c = rnd.nextInt(80)+1;//trouver un chiffre de 1 à 80 (0-79 +1)
        //le maximum de lettre est 80
        a = new char[c];//le nombre de place dans le tableau n'étant pas encore déclaré, c'est le c généré avec random qui va décider.
        for (int i = 0; i <= a.length - 1; i++) {
            char random = (char) (rnd.nextInt(bound) + b);
            a[i] = random;//générer des lettres random pour chaque place du tableau.
        }
        return a;//retourner le tableau.
    }
    public static char [] C4 (char [] c, int bound, char b){//confirmation du message random et changement selon les choix
        Scanner sc=new Scanner(System.in);
        Random rnd=new Random();
        int choix;
        int a;
        rot_random(c);//afficher le message random généré et confirmer.
        choix=sc.nextInt();
        //Lire si le choix est oui ou non
        while (choix < 1 || choix > 2) {
            System.out.println("Veuillez choisir un option valide.");
            choix = sc.nextInt();
        }
        while (choix==2) {//tant que le choix est oui, générer des messages random.
            c=generer(c,bound,b);//le même programme mais dans une boucle
            rot_random(c);//confirmer une autre fois
            choix=sc.nextInt();//relire le choix: Un code random peut être généré autant que possible.
        }
        System.out.print("Voici le message crypté généré: ");/*juste pour que le message crypté
        soit en haut du message décrypté.
        */
        for (int w=0; w<=c.length-1; w++){
            System.out.print(c[w]);
        }
        System.out.println();
        return c;
    }

    public static void rot_random(char[] a4) {
        System.out.print("Voici le message crypté généré: ");
        for (int i = 0; i < a4.length; i++) {
            System.out.print(a4[i]);
        }
        System.out.println();
        System.out.println("Voulez-vous le changer?");
        System.out.println("1- Non");
        System.out.println("2- Oui");
        //un menu pour confirmer le message random
    }

    public static void rot_message_random(char[] a3) {
        System.out.print("Voici le message décrypté généré: ");
        for (int i = 0; i < a3.length; i++) {
            System.out.print(a3[i]);
        }
        System.out.println();
        //message random décrypté
    }

    public static char [] c_cesar(char[] cesar1) {
        Scanner sc = new Scanner(System.in);
        String cesar;
        System.out.println("César 3d:");
        System.out.println("Saisissez le code (Pressez enter 2 fois):");
        cesar = sc.nextLine();
        sc.nextLine();
        cesar1 = cesar.toCharArray();
        cesar1=confirmer3(cesar,cesar1);
        //Le même programme que rot-13
        message_crypté(cesar1);/*Le message est affiché ici et non à la fin parce que vers la fin,
        le tableau cesar1 est déjà décrypté.
        */
        cesar1=alt(cesar1,3,23,'a','w','x','z');
        return cesar1;
    }

    public static char [] c_cesar_rnd(char[] cesar_rnd) {
        Random rnd = new Random();
        System.out.println("César 3d random:");
        cesar_rnd=generer(cesar_rnd,26,'a');
        cesar_rnd=C4(cesar_rnd,26,'a');
        cesar_rnd=alt(cesar_rnd,3,23,'a','w','x','z');
        return cesar_rnd;
    }

    public static char [] cesar3d(char [] c3d) {//erreur de nom, c'est censé être cesar_choix mais je l'ai gardé comme ça.
        Scanner sc = new Scanner(System.in);
        System.out.println("César au choix:");
        String cesar3d;
        System.out.println("Entrez le code (Pressez enter 2 fois):");
        cesar3d = sc.nextLine();
        sc.nextLine();
        c3d = cesar3d.toCharArray();/* les lettres sont transformés en tableau avant de confirmer
        vu que ça se peut que ça soit le bon code (pas besoin de changement) et le transformer ici
        est plus simple que de le transformer après. Et simplement mettre cette ligne après confirmer3
        ne marche pas non plus.
        */
        int choix=0;
        choix=CR01(choix);//demander si c'est un décalage vers la droite ou la gauche
        int decal=0;
        decal=CR02(decal);//demander le décalage en question et l'enregistrer dans la variable décal
        c3d=confirmer3(cesar3d,c3d);
        message_crypté(c3d);
        c3d=CR03(c3d, choix,decal);//c'est un décodage plus compliqué donc je n'ai pas utilisé alt mais une autre méthode.
        return c3d;
    }
    public static int CR01 (int choix) {
        Scanner sc = new Scanner(System.in);
        System.out.println("++++++++++++++++++++++++++++++++");
        System.out.println("+ Voulez-vous le décaler par:  +");
        System.out.println("+ 1- La droite                 +");
        System.out.println("+ 2- La gauche                 +");
        System.out.println("++++++++++++++++++++++++++++++++");
        choix = sc.nextInt();
        while (choix < 1 || choix > 2) {
            System.out.println("Veuillez choisir un option valide.");
            choix = sc.nextInt();
        }
        int choix2;
        System.out.println("Vous avez fait le choix "+choix+". Est-ce bien ça?");
        System.out.println("1-Oui");
        System.out.println("2-Non");
        choix2=sc.nextInt();
        while (choix2 < 1 || choix2 > 2) {
            System.out.println("Veuillez choisir un option valide.");
            choix2 = sc.nextInt();
        }
        if (choix2==2){
            System.out.println("Ok. Saissisez votre décalage de nouveau:");
            choix=sc.nextInt();
            while (choix < 1 || choix > 2) {
                System.out.println("Veuillez choisir un option valide.");
                choix = sc.nextInt();
            }
        }
        return choix;
    }
    public static int CR02 (int decal){
        Scanner sc=new Scanner(System.in);
        System.out.println("De combien voulez-vous le décaler?");
        decal = sc.nextInt();
        while (decal < 1 || decal > 13) {
            System.out.println("Le chiffre ne peut pas dépasser 14 ou etre plus petit que 1");
            decal=sc.nextInt();
        }
        int choix2;
        System.out.println("Vous avez choisi de le décaler de "+decal+". Est-ce bien ça?");
        System.out.println("1-Oui");
        System.out.println("2-Non");
        choix2=sc.nextInt();
        while (choix2 < 1 || choix2 > 2) {
            System.out.println("Veuillez choisir un option valide.");
            choix2 = sc.nextInt();
        }
        if (choix2==2){
            System.out.println("Ok. Saissisez votre décalage de nouveau:");
            decal=sc.nextInt();
            while (decal < 1 || decal > 13) {
                System.out.println("Le chiffre ne peut pas dépasser 14 ou etre plus petit que 1");
                decal=sc.nextInt();
            }
        }
        return decal;
    }
    public static char [] CR03 (char []a,int choix, int decal){
        int y;//variable utilisé dans les calculs plus tard
        if (choix == 1) {//Si c'est un décalage vers la gauche
            for (int i = 0; i <= a.length-1; i++) {
                if (a[i]>= 'a' && a[i]<='z') {//Entre a et z
                    a[i] = (char) (a[i] + decal);//la lettre en question + le décalage
                    if (a[i] >= 123) {//Si il dépasse 123 (après z)
                        y = a[i] - 123;//enregistrer la différence  (ça a dépassé de combien)
                        a[i] = (char) (97 + y);//retourne à a et ajouter la différence
                    }
                }
                if (a[i]>='A'&&a[i]<='Z'){
                    a[i]=(char) (a[i] + decal);
                    if (a[i]>=91){
                        y=a[i]-91;
                        a[i]=(char)(65+y);
                    }
                }//la même chose, mais avec les nombres différents.

            }
        }
        else {
            for (int u = 0; u < a.length; u++) {
                a[u]= (char) (a[u]-decal);//Vu que c'est un décalage vers la gauche, c'est une soustraction.
                if (a[u]<=96){//Si après la soustraction c'est moins que a
                    y=a[u]+123;//faire la somme de ça et z
                    a[u]= (char) (y-97);//soustraire par a pour recommencer à z et aller au bon lettre
                }
                if (a[u]>='A'&&a[u]<='Z') {
                    a[u]=(char) (a[u] + decal);
                    if (a[u]>=91){
                        y=a[u]-91;
                        a[u]=(char)(65+y);//en bref c'est le même programme que le décalage de droite mais en + au lieu de -
                    }
                }
            }
        }
        return a;
    }
    public static char[] cesarRND (char [] random_cesar){
        Random rnd = new Random();
        Scanner sc=new Scanner(System.in);
        System.out.println("César aux choix random:");
        random_cesar=generer(random_cesar,26,'a');
        int choix=0;
        choix=CR01(choix);
        int decal=0;
        decal=CR02(decal);
        random_cesar=C4(random_cesar,26,'a');
        CR03(random_cesar,choix,decal);
        return random_cesar;
    }
    public static void Poly_Alphavariante (char [] P_A){
        Scanner sc=new Scanner(System.in);
        System.out.println("Poly-alphavariante:");
        String code_A;
        System.out.println("Entrez le code (Pressez enter 2 fois):");
        code_A=sc.nextLine();
        sc.nextLine();
        P_A=code_A.toCharArray();

        P_A=confirmer3(code_A,P_A);
        message_crypté(P_A);
        char [] alt=new char[P_A.length];//le programme suivant n'est pas dans une méthode vu que je ne peux pas retourner 2 tableaux.
        for (int i=0; i<=P_A.length-1; i++){
            if (P_A[i]=='a'||P_A[i]=='e'||P_A[i]=='i'||P_A[i]=='o'||P_A[i]=='u'||P_A[i]=='y'||
                    P_A[i]=='A'||P_A[i]=='E'||P_A[i]=='I'||P_A[i]=='O'||P_A[i]=='U'||P_A[i]=='Y') {
                switch (P_A[i]) {
                    case 'a','A':
                        P_A[i] = '+';
                        alt[i]='0';//pour l'affichage du '?' à la fin
                        break;
                    case 'e','E':
                        P_A[i] = '=';
                        alt[i]='0';
                        break;
                    case 'i','I':
                        P_A[i] = '&';
                        alt[i]='0';
                        break;
                    case 'o','O':
                        P_A[i] = '*';
                        alt[i]='0';
                        break;
                    case 'u','U':
                        P_A[i] = '!';
                        alt[i]='0';
                        break;
                    case 'y','Y':
                        P_A[i] = '$';
                        alt[i]='0';
                        break;
                    default:
                }
            }
            else if (P_A[i]>='0'&&P_A[i]<='4'){
                P_A[i]= (char) (57-(P_A[i]-48));
            }
            else if (P_A[i]>='5'&&P_A[i]<='9'){
                P_A[i]=(char)(48+(57-P_A[i]));
            }
            else if (P_A[i]>='a'&&P_A[i]<='v'||P_A[i]>='A'&&P_A[i]<='V'){
                P_A[i]=P_A[i]+=4;
            }
            else if (P_A[i]>='w'&&P_A[i]<='z'||P_A[i]>='W'&&P_A[i]<='V'){
                P_A[i]=P_A[i]-=22;
            }
            else if (P_A[i]==' '){//je pouvais ne rien écrire, mais juste pour éviter des possibilité de bug...

            }
        }
        System.out.println();
        System.out.print("Voici le message décrypté:");
        for (int t=0; t<=P_A.length-1; t++){
            if (P_A[t]>=33&& P_A[t]<=47||P_A[t]>=58&&P_A[t]<=64||P_A[t]>=91&&P_A[t]<=96||P_A[t]>=123&&P_A[t]<=126) {
                if (alt[t]!='0'){//quand alt de cette place est = à 0, alors le symbole de cette place est issue d'une voyelle transformée. Donc je ne dois pas ajouter de ? devant.
                    System.out.print("?"+P_A[t]);
                }
                else {
                    System.out.print(P_A[t]);//donc, si c'est une voyelle, je l'afficher normalement.
                }
            }
            else {
                System.out.print(P_A[t]);
            }
        }
        System.out.println();
    }
    public static void PA_RND (char [] P_R){
        Random rnd = new Random();
        Scanner sc=new Scanner(System.in);
        System.out.println("Poly-alphavariante random:");
        P_R=generer(P_R,93,'!');
        P_R=C4(P_R,93,'!');
        int x=0;
        message_crypté(P_R);
        char [] alt=new char[P_R.length];
        for (int i=0; i<=P_R.length-1; i++){
            if (P_R[i]=='a'||P_R[i]=='e'||P_R[i]=='i'||P_R[i]=='o'||P_R[i]=='u'||P_R[i]=='y'||
                    P_R[i]=='A'||P_R[i]=='E'||P_R[i]=='I'||P_R[i]=='O'||P_R[i]=='U'||P_R[i]=='Y') {
                switch (P_R[i]) {
                    case 'a','A':
                        P_R[i] = '+';
                        alt[i]='0';
                        break;
                    case 'e','E':
                        P_R[i] = '=';
                        alt[i]='0';
                        break;
                    case 'i','I':
                        P_R[i] = '&';
                        alt[i]='0';
                        break;
                    case 'o','O':
                        P_R[i] = '*';
                        alt[i]='0';
                        break;
                    case 'u','U':
                        P_R[i] = '!';
                        alt[i]='0';
                        break;
                    case 'y','Y':
                        P_R[i] = '$';
                        alt[i]='0';
                        break;
                    default:
                }
            }
            else if (P_R[i]>='0'&&P_R[i]<='4'){
                P_R[i]= (char) (57-(P_R[i]-48));
            }
            else if (P_R[i]>='5'&&P_R[i]<='9'){
                P_R[i]=(char)(48+(57-P_R[i]));
            }
            else if (P_R[i]>='a'&&P_R[i]<='v'||P_R[i]>='A'&&P_R[i]<='V'){
                P_R[i]=P_R[i]+=4;
            }
            else if (P_R[i]>='w'&&P_R[i]<='z'||P_R[i]>='W'&&P_R[i]<='V'){
                P_R[i]=P_R[i]-=22;
            }
            else if (P_R[i]==x){
                if (x==0){
                    P_R[i]='9';
                }
                else {

                }
            }
            else if (P_R[i]==' '){

            }
        }
        System.out.println("Voici le message décrypté:");
        for (int t=0; t<=P_R.length-1; t++){
            if (P_R[t]>=33&& P_R[t]<=47||P_R[t]>=58&&P_R[t]<=64||P_R[t]>=91&&P_R[t]<=96||P_R[t]>=123&&P_R[t]<=126) {
                if (alt[t]!='0'){
                    System.out.print("?"+P_R[t]);
                }
                else {
                    System.out.print(P_R[t]);
                }
            }
            else {
                System.out.print(P_R[t]);
            }
        }
        System.out.println();
    }
}
