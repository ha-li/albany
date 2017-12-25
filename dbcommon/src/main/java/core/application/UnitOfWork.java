package core.application;

import javax.transaction.Status;
import javax.transaction.UserTransaction;

/**
 * An application manageable UserTransaction object.
 * Created by: hlieu.
 */
public class UnitOfWork implements AutoCloseable {

   private static UserTransaction tx;

   public UnitOfWork () {}

   public static UnitOfWork beginUnitOfWork () {
      try {

         if (     tx != null
               && (tx.getStatus () == Status.STATUS_ACTIVE || tx.getStatus () == Status.STATUS_MARKED_ROLLBACK)
             ) {
            // LOG this: "Cannot begin a transaction within another transaction. Rolling back."
            tx.rollback ();
            tx = null;
         }

         UnitOfWork unit = new UnitOfWork ();
         tx = Application.getUserTransaction ();
         tx.begin ();
         return unit;
      } catch (Exception e) {
         // LOG this exception.
         throw new RuntimeException ("UnitOfWork failed to begin.", e);
      }
   }

   public static void rollbackUnitOfWork () {
      try {
         if (tx != null) {
            int status = tx.getStatus ();
            if (status == Status.STATUS_NO_TRANSACTION) {
               //tx = null;
               return;
            }
            tx.rollback ();
         }
      } catch (Exception e) {
         // Log this exception, rollback exceptions mean a serious problem with your application.
         throw new RuntimeException ("UnitOfWork failed to rollback.", e);
      } finally {
         tx = null;
      }
   }

   public static void commitUnitOfWork () {
      try {
         if (tx != null) {
            tx.commit ();
         }
      } catch (Exception e) {
         throw new RuntimeException ("UnitOfWork failed to commit.", e);
      } finally {
         tx = null;
      }
   }

   public void rollback () {
      UnitOfWork.rollbackUnitOfWork ();
   }

   public void commit () {
      UnitOfWork.commitUnitOfWork ();
   }

   @Override
   public void close () {
      UnitOfWork.rollbackUnitOfWork ();
   }
}
