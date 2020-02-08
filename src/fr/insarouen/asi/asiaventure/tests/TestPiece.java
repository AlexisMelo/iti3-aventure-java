package fr.insarouen.asi.asiaventure.tests;

import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;

import static org.junit.Assert.*;

import fr.insarouen.asi.asiaventure.Monde;
import fr.insarouen.asi.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.asiaventure.elements.structure.Porte;
import fr.insarouen.asi.asiaventure.elements.objets.Objet;

public class TestPiece {

    public Monde monde = new Monde("Rouen");
    public Piece piece = new Piece("Piece n°1",this.monde);

    /**
     * Mettre à true si on veut afficher que la classe est entrain d'être testée
     */
    public static boolean printClassBeingTested = true;

    /**
     * Mettre à true si on veut afficher un exemple de toString de la classe testée
     */
    public static boolean printObjectToString = true;

    @Before
    public void init() {
      if(this.printClassBeingTested) {
        System.out.println("Testing class Piece");
        this.printClassBeingTested = false;
      }
      if(this.printObjectToString) {
        System.out.println(this.piece);
        this.printObjectToString = false;
      }
    }

    @Test
    public void test_addPorte() {
      Porte p = new Porte("porte 1 ",this.monde);
      this.piece.addPorte(p);
      assertTrue(this.piece.aLaPorte(p));
    }

    @Test
    public void test_deposer() {
      Objet o = new Objet("obj 1",this.monde){
        public boolean estDeplacable() {
          return true;
        }
      };
      this.piece.deposer(o);
      assertTrue(this.piece.contientObjet(o));
    }

    @Test
    public void test_getPorte() {
      Porte p = new Porte("porte 2",this.monde);
      this.piece.addPorte(p);
      assertEquals(p, this.piece.getPorte("porte 2"));
    }

    @Test
    public void test_retirer() {
      Objet o = new Objet("obj2", this.monde){
        public boolean estDeplacable() {
          return false;
        }
      };
      this.piece.deposer(o);
      assertTrue(this.piece.contientObjet(o));
      this.piece.retirer(o);
      assertFalse(this.piece.contientObjet(o));

    }
}
