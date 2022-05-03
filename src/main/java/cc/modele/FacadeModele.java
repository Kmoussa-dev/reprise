package cc.modele;

import cc.modele.data.boissons.Boisson;
import cc.modele.data.comptes.Compte;
import cc.modele.data.comptes.TypeCompte;
import cc.modele.data.machines.Machine;
import cc.modele.exceptions.*;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Façade du modèle.
 */
@Component
public class FacadeModele {

    // TODO compléter la classe et les méthodes
    private List<Compte> comptes;

    public FacadeModele(){
        comptes=new ArrayList<>();
    }

    /**
     * Créer un nouveau compte de type "drinker".
     *
     * @param login    le login du compte à créer
     * @param password le password du compte à créer
     * @return le compte créé
     * @throws CompteDejaExistantException      si un compte existe déjà avec le même login (quel que soit son type)
     * @throws InformationsIncompletesException si les informations fournies sont incomplètes (login ou password vide)
     */
    public Compte creerCompteDrinker(String login, String password) throws InformationsIncompletesException, CompteDejaExistantException {
        if (login.isBlank()||password.isBlank()|| Objects.isNull(login)||Objects.isNull(password)) throw new InformationsIncompletesException();
        if(comptes.stream().anyMatch(cpte->cpte.getLogin()==login)) throw new CompteDejaExistantException();
        Compte compte=new Compte(login,password, TypeCompte.DRINKER);
        comptes.add(compte);
        return compte;
    }

    /**
     * Créer un nouveau compte de type "fabulous".
     *
     * @param login    le login du compte à créer
     * @param password le password du compte à créer
     * @return le compte créé
     * @throws CompteDejaExistantException      si un compte existe déjà avec le même login (quel que soit son type)
     * @throws InformationsIncompletesException si les informations fournies sont incomplètes (login ou password vide)
     */
    public Compte creerCompteFabulous(String login, String password) throws InformationsIncompletesException, CompteDejaExistantException {
        if (login.isBlank()||password.isBlank()|| Objects.isNull(login)||Objects.isNull(password)) throw new InformationsIncompletesException();
        if(comptes.stream().anyMatch(cpte->cpte.getLogin()==login)) throw new CompteDejaExistantException();
        Compte compte=new Compte(login,password, TypeCompte.FABULOUS);
        comptes.add(compte);
        return compte;
    }

    /**
     * Retourne l'ensemble des comptes.
     *
     * @return une collection de tous les comptes
     */
    public Collection<Compte> getAllComptes() {
        return comptes;
    }

    /**
     * Retourne un compte existant, d'après son id.
     *
     * @param idCompte l'identifiant du compte recherché
     * @return le compte
     * @throws CompteInconnuException si aucun compte n'existe avec cet identifiant
     */
    public Compte getCompteById(Integer idCompte) throws CompteInconnuException {
        if (!comptes.stream().anyMatch(compte -> compte.getId()==idCompte)) throw new CompteInconnuException();
        Compte compte=comptes.stream().filter(compte1 -> compte1.getId()==idCompte).collect(Collectors.toList()).get(0);
        return compte;
    }

    /**
     * Retourne un compte existant, d'après son login.
     *
     * @param login le login du compte recherché
     * @return le compte
     * @throws CompteInconnuException si aucun compte n'existe avec ce login
     */
    public Compte getCompteByLogin(String login) throws CompteInconnuException {
        if (!comptes.stream().anyMatch(compte -> compte.getLogin()==login)) throw new CompteInconnuException();
        Compte compte=comptes.stream().filter(compte1 -> compte1.getLogin()==login).collect(Collectors.toList()).get(0);
        return compte;
    }

    /**
     * Modifie le type d'un compte.
     *
     * @param idCompte    l'identifiant du compte à modifier
     * @param nouveauType le nouveau type du compte
     * @return le compte modifié
     * @throws CompteInconnuException     si aucun compte n'existe avec cet identifiant
     * @throws TypeCompteInconnuException si le nouveau type de compte n'existe pas
     */
    public Compte modifierTypeCompte(Integer idCompte, String nouveauType) throws TypeCompteInconnuException, CompteInconnuException {
        if (!TypeCompte.getAllTypes().contains(nouveauType)) throw new TypeCompteInconnuException();
//        this.getCompteById(idCompte).setType(nouveauType);
//        return this.getCompteById(idCompte);
        Compte compte=getCompteById(idCompte);
        compte.setType(nouveauType);
        return compte;
    }

    /**
     * Ajoute une nouvelle machine.
     *
     * @param nom          le nom de la machine à ajouter
     * @param typeBoissons le type de boissons servi par la machine à ajouter
     * @param salle        la salle où se trouve la machine à ajouter
     * @return la machine ajoutée
     * @throws InformationsIncompletesException si les informations fournies sont incorrectes
     * @throws MachineDejaExistanteException    si une machine avec le même nom existe déjà
     * @throws TypeBoissonInconnuException      si le type de boisson n'existe pas
     * @throws FormatSalleIncorrectException    si le format du nom de la salle est incorrect (doit être de la forme "1 lettre suivie de 2 chiffres", p.ex. "A38")
     */
    public Machine ajouterMachine(String nom, String typeBoissons, String salle) throws MachineDejaExistanteException, InformationsIncompletesException, TypeBoissonInconnuException, FormatSalleIncorrectException {
        if ()
        return null;
    }

    /**
     * Retourne l'ensemble des machines.
     *
     * @return une collection de toutes les machines
     */
    public Collection<Machine> getAllMachines() {
        // TODO
        return null;
    }

    /**
     * Retourne l'ensemble des machines présentes dans une salle.
     *
     * @param salle la salle dans laquelle se trouvent les machines
     * @return une collection des machines présentes dans la salle (éventuellement vide, si la salle ne contient aucune machine)
     * @throws FormatSalleIncorrectException si le format du nom de la salle est incorrect (doit être de la forme "1 lettre suivie de 2 chiffres", p.ex. "A38")
     */
    public Collection<Machine> getAllMachinesBySalle(String salle) throws FormatSalleIncorrectException {
        // TODO
        return null;
    }

    /**
     * Récupère une machine existante, selon son id.
     *
     * @param idMachine l'identifiant de la machine recherchée
     * @return la machine
     * @throws MachineInconnueException si aucune machine n'existe avec cet identifiant
     */
    public Machine getMachineById(Integer idMachine) throws MachineInconnueException {
        // TODO
        return null;
    }

    /**
     * Récupère une machine existante, selon son nom.
     *
     * @param nom le nom de la machine recherchée
     * @return la machine
     * @throws MachineInconnueException si aucune machine n'existe avec ce nom
     */
    public Machine getMachineByNom(String nom) throws MachineInconnueException {
        // TODO
        return null;
    }

    /**
     * Prépare une nouvelle boisson.
     *
     * @param idMachine   l'identifiant de la machine sur laquelle préparer la boisson
     * @param typeBoisson le type de boisson souhaité
     * @param idCompte    l'identifiant du compte demandant la préparation de la boisson
     * @param nbSucres    le nombre de sucres à ajouter dans la boisson (entier positif ou nul)
     * @return la boisson en cours de préparation
     * @throws MachineInconnueException    si aucune machine n'existe avec cet identifiant
     * @throws CompteInconnuException      si aucun compte n'existe avec cet identifiant
     * @throws TypeBoissonInconnuException si le type de boisson n'existe pas
     * @throws NbSucresIncorrectException  si le nombre de sucres est incorrect
     */
    public Boisson preparerBoisson(Integer idMachine, String typeBoisson, Integer idCompte, Integer nbSucres) throws CompteInconnuException, MachineInconnueException, TypeBoissonInconnuException, NbSucresIncorrectException {
        // TODO
        return null;
    }

}
