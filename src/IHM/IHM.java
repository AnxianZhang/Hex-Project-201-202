package IHM;

import app.IIHM;
import game.Plateau;
import player.Identity;
import java.util.Scanner;

public class IHM implements IIHM {
    private final Scanner sc = new Scanner(System.in);

    /**
     * Cette méthode permet de proposer à l'utilisateur de choisir le type
     * de joueur qui va ouer (IA ou humain) et ensuite récupérer cette valeur
     *
     * @return retourne un objet humain ou IA de type Identity, ce sera le type du joueur
     *
     * @see #afficher_choix_possible()
     * @see #demander_un_integer(int, int)
     * @see Identity#values()
     */
    @Override
    public Identity recuperer_type_de_joueur(){
        System.out.println("Choissisez le type du joueur par un numéro" );
        afficher_choix_possible();

        int choix = demander_un_integer(Identity.values().length);

        return Identity.values()[choix];
    }

    /**
     * Cette méthode permet simplement d'afficher à l'utilisateur les choix
     * de type de joueur qui peut choisir. C'est une méthode d'affichage.
     *
     * @see Identity#values()
     * @see Identity#toString()
     * @see Stat#values()
     */
    private void afficher_choix_possible(){

        for (int i = 0; i < Identity.values().length ;++i){
            System.out.println("choix " + i + " pour l'" + Identity.values()[i].toString());
        }
    }

    /**
     * Cette méthode est une méthode d'affichage. Elle permet d'afficher
     * à l'utilisateur les résultats de la partie.
     *
     * @param gagnant paramètre qui fait référence à un joueur
     * @param perdant paramètre qui fait référence à un joueur
     *
     * @see Player#getPawnColor()
     * @see Stat#name()
     */
    @Override
    public void afficher_resultat(String gagnant, String perdant){
        System.out.println("Les " + gagnant + " ont gagner ");
        System.out.println("Les " + perdant + " ont perdu");
        System.out.println("La partie est finie");
    }

    /**
     * Méthode qui permet d'afficher le plateau
     *
     * @param p objet plateau
     */
    @Override
    public void mettre_a_jour_plateau(Plateau p){
        System.out.println(p);
    }

    /**
     * Cette méthode permet d'afficher le coup d'un joueur, où est-ce qu'il a joué ?
     *
     * @param joueur le joueur qui a joué
     * @param choix la case où le joueur à joué
     *
     * @see Stat#name()
     * @see Player#getPawnColor()
     */
    @Override
    public void afficher_le_coup(String player_name, int choix){
        System.out.println( player_name + " ont jouées à la case " + choix);
    }

    /**
     * Cette méthode demande aux joueurs où est-ce qu'ils veulent poser leur pion
     *
     * @param p le plateau sur lequelle les joueurs jouent
     * @param joueur le joueur à qui on demande où il va jouer
     *
     * @return retourne un entier entre 0 et la taille du plteau, c'est là case
     * où le joueur va jouer
     *
     * @see Stat#name()
     * @see Player#getPawnColor()
     * @see #demander_un_integer(int, int)
     * @see Plateau#taille()
     */
    @Override
    public int demander_coup_a_jouer(Plateau p, String joueur){
        System.out.print("C'est au tour des " + joueur +" de jouer sur le plateau: ");
        return demander_un_integer(p.taille() * p.taille());
    }

    /**
     * Cette méthode va récupérer la valeur de la position où le joueur veut jouer
     *
     * @param borne_inferieur_incluse début du plateau
     * @param borne_superieur fin du plateau
     *
     * @return retourne un entier qui correspond au choix du joueur
     *
     * @see #IsInt() méthode qui va vérifier que c'est un entier
     * @see Scanner#nextInt()
     * @see Scanner#nextLine()
     */
    private int demander_un_integer(int borne_superieur){
        while (true) {
            if(!sc.hasNextInt()){
                System.out.print("Un chiffre est requis, saisissez votre choix :");
                sc.nextLine();
            }
            else  {
                int choix = sc.nextInt() ;
                if (choix < borne_superieur && choix >= 0){
                    return choix;
                }
                System.out.print("Un nombre valide est requis, saisissez votre choix : ");
                sc.nextLine();
            }
        }
    }
}
