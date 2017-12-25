package rest.resources;

import core.application.UnitOfWork;
import core.repository.JpaRepository;
import bacs.domain.Transaction;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import java.math.BigDecimal;
import java.time.LocalDate;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Created by hlieu on 10/4/17.
 */
@Path("transaction")
@Produces({APPLICATION_JSON})
@Consumes({APPLICATION_JSON})
public class TransactionResource {

    @POST
    @Path ("add")
    public Response createTransaction (Transaction transaction) {
        try (UnitOfWork uow = UnitOfWork.beginUnitOfWork ()) {

            transaction.setRemittanceDate(LocalDate.now());

            JpaRepository.save (transaction);

            UnitOfWork.commitUnitOfWork ();
        }
        System.out.println ("Hello");
        return Response.ok(transaction).build();
    }

    @GET
    @Path("{id}")
    public Response get (@PathParam("id") String id) {
        Transaction transaction = null;
        try (UnitOfWork unit = UnitOfWork.beginUnitOfWork()) {
            transaction = JpaRepository.getById (Transaction.class, id);
            UnitOfWork.commitUnitOfWork();
        }

        return Response.ok ().entity (transaction).build();
    }
}
