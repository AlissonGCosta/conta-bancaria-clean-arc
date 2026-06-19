package br.com.costa.conta_bancaria_clean_arc.infrastructure.controller;

import br.com.costa.conta_bancaria_clean_arc.core.usecase.CreateAcount;
import br.com.costa.conta_bancaria_clean_arc.core.usecase.TransfairUseCase;
import br.com.costa.conta_bancaria_clean_arc.infrastructure.dataprovider.CreateAcountImp;
import br.com.costa.conta_bancaria_clean_arc.infrastructure.persistence.entity.dto.Response.AcountAmountResponse;
import br.com.costa.conta_bancaria_clean_arc.infrastructure.persistence.entity.dto.Response.AcountResponse;
import br.com.costa.conta_bancaria_clean_arc.infrastructure.persistence.entity.dto.request.AcountRequest;
import br.com.costa.conta_bancaria_clean_arc.infrastructure.persistence.entity.dto.request.AcountRequestAmount;
import br.com.costa.conta_bancaria_clean_arc.infrastructure.persistence.entity.mapper.AcountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/acount")
@RequiredArgsConstructor
public class AcountController {

    private final AcountMapper acountMapper;
    private final CreateAcount  createAcount;
    private final TransfairUseCase transfairUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
     AcountResponse createAccount(@RequestBody AcountRequest accountRequest) {

        createAcount.createAcount(acountMapper.toEntity(accountRequest));
        return acountMapper.toResponseEntity(accountRequest);

    }

    @PatchMapping("/{txNumberToAcount}/{txFromAcount}/transfer")
    @ResponseStatus(HttpStatus.OK)
    AcountAmountResponse transferAccount(@PathVariable String txNumberToAcount, @PathVariable String txNumberFromAcount, @RequestBody AcountRequestAmount accountRequestAmount ) {



        transfairUseCase.TransfairUseCase(txNumberToAcount, txNumberFromAcount,   accountRequestAmount.getAmount());

        return acountMapper.toResponseAmountEntity(accountRequestAmount);
    }
}
