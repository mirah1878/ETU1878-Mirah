# CHAT
AccesServeur : serveur,
Acces : client

AccesServeur => Main.java => " public static final String filename ="D:\\socket_1878\\serveur\\Message\\"; "  doit etre changer selon le pc 

Execution AccesServeur => java main.Main
Execution Acces => java main.Main

Serveur: il y a 5 classes dedans
    +SendMessage.java  2 fonctions : [extends Thread]
        -sendMessage : Cette fonction sert a recupere les message dans un fichier texte
        -run : diffuser le message au client

    +Function.java  4 fonctions : 
        -manisaline : compter les lignes dans un fichier texte
        -getData :  recevoir le message du client
        -createFile : creer un fichier texte quand il n'existe pas
        -enregistrer : sert a enregistrer toutes les discussions

    +Client.java : comme chez le client
        Nom, group , DataInputStream , ObjectOutputStream

    +Chat.java 1 fonction : [extends Thread]
        run : lire le message envoye par le client    

    +Main.java 


Client : il y a 4 classes dedans
    +Main.java
    +Fenetre.java : Affichage (swing)
    +Listener.java [implements ActionListener] :
        -Listner button "send"
    +TextThread.java 2 fonctions : [extends Thread]
        -showMessage : sert a recuperer les textes dans JTextfield
        -run :  sert a montrer tout les message   


