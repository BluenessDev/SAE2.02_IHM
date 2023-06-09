package bluenessdev.modele;

import java.util.Scanner;

public class Quete {
    int numero;

    String pos;

    int [] positionQuete = new int[2];

    String precond;

    int [] preconditions = new int[4];

    int duree;
    int experience;
    String intitule;

    /**
     * Constructeur de la classe Quete
     * @param ligne : ligne du fichier texte scenario_telnombre.txt
     * @return void
     */
    public Quete(String ligne) {
        Scanner scanner = new Scanner(ligne).useDelimiter("\\|");
        while(scanner.hasNext()) {
            this.numero = scanner.nextInt();
            String pos = scanner.next();
            pos = pos.replace("(", "");
            pos = pos.replace(")", "");
            pos = pos.replace(" ", "");
            Scanner scanPos = new Scanner(pos).useDelimiter(",");
            int i = 0;
            while (scanPos.hasNext()) {
                positionQuete[i] = Integer.parseInt(scanPos.next());
                i++;
            }
            String precond = scanner.next();
            precond = precond.replace("(", "");
            precond = precond.replace(")", "");
            precond = precond.replace(" ", "");
            Scanner scanPrecondition = new Scanner(precond).useDelimiter(",");
            int j = 0;
            while (scanPrecondition.hasNext()) {
                String extrait = scanPrecondition.next();
                if (!extrait.equals(""))
                    preconditions[j] = Integer.parseInt(extrait);
                j++;
            }
            this.duree = scanner.nextInt();
            this.experience = scanner.nextInt();
            this.intitule = scanner.next();
        }
    }

    /**
     * Methode qui verifie si la quete n'a aucune precondition
     * @return true si la quete n'a aucune precondition, false sinon
     */
    public boolean aucunePrecond() {
        for (int i = 0; i < this.preconditions.length; i++) {
            if (preconditions[i] != 0)
                return false;
        }
        return true;
    }

    /**
     * Methode qui retourne le numero de la quete
     * @return la precondtion de la quete
     */
    public int [] getPrecondition() {
        return preconditions;
    }

    public int [] getPositionQuete(){ return positionQuete; }

    public int getNumero() { return numero; }

    public String toString() {
        return numero + " [" + positionQuete[0] + "," + positionQuete[1] + "] [" + "(" + preconditions[0] + "," + preconditions[1] + ")" + "," + "(" + preconditions[2] +  "," + preconditions[3] + ")" + "] " + duree + " " + experience + " " + intitule;
    }

    /**
     * Methode qui retourne l'intitule de la quete
     * @return int, l'experience de la quete
     */
    public int getExperience() {
        return experience;
    }

    /**
     * Methode qui retourne la duree de la quete
     * @return int, la duree de la quete
     */
    public int getDuree() {
        return duree;
    }

}