package app.subscription;

public class TransitionStateApp {

   /* public static void inTransient () {
      Item item = new Item ();
      boolean isTransient = RepositoryUtil.isTransient (item);
      System.out.println ("is transient = " + isTransient);
   }

   public static void notTransient () throws Exception {
      Item item;
      try (UnitOfWork unitofwork = UnitOfWork.beginUnitOfWork ()) {
         item = JpaRepository.getById (Item.class, "15d5c00e-ffae-4267-a1d3-0f127de95ced");
      }

      boolean isTransient = RepositoryUtil.isTransient (item);
      System.out.println ("is transient = " + isTransient);
   }

   public static void inPersistent () throws Exception {
      Item item;
      try (UnitOfWork unitOfWork = UnitOfWork.beginUnitOfWork ()) {
         item = JpaRepository.getById (Item.class, "15d5c00e-ffae-4267-a1d3-0f127de95ced");
      }

      boolean isPersistent = RepositoryUtil.isPersistent (item);
      System.out.println ("is persistent = " + isPersistent);
   }

   public static void isDetached () throws Exception {
      Item item;
      try (UnitOfWork uow = UnitOfWork.beginUnitOfWork ()) {
         item = JpaRepository.getById (Item.class, "15d5c00e-ffae-4267-a1d3-0f127de95ced");
      }
      boolean isDetached = RepositoryUtil.isDetached (item);
      System.out.println ("is detached = " + isDetached);
   }

   public static void main (String[] args) throws Exception {
      //TransitionStateApp.inTransient ();
      //TransitionStateApp.notTransient ();
      //TransitionStateApp.inPersistent ();
      TransitionStateApp.isDetached ();
   } */
}
