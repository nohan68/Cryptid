package Modele;

import Modele.Types.TypePiece;

public class Piece {
    private TypePiece typePiece;
    private Joueur proprietaire;

    public Piece(TypePiece typePiece, Joueur proprietaire){
        this.typePiece = typePiece;
        this.proprietaire = proprietaire;
    }

    public TypePiece getTypePiece() {
        return typePiece;
    }

    public Joueur getProprietaire() {
        return proprietaire;
    }

    @Override
    public String toString(){
        return "\n [" + this.proprietaire + " " + this.typePiece + " ]";
    }
}
