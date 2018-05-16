package com.crud.library.mapper;

import com.crud.library.domain.Borrow;
import com.crud.library.dto.BorrowDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BorrowMapper {

    public Borrow mapToBorrow(final BorrowDto borrowDto) {
        return new Borrow(
          borrowDto.getId(),
          borrowDto.getBorrowDateTime(),
          borrowDto.getReturnDateTime()
        );
    }

    public BorrowDto mapToBorrowDto(final Borrow borrow) {

        return new BorrowDto(
                borrow.getId(),
                borrow.getBorrowDateTime(),
                borrow.getReturnDateTime()
        );
    }

    public List<Borrow> mapToBorrowList (final List<BorrowDto> borrowDtoList) {
        return borrowDtoList.stream()
                .map(borrowDto -> new Borrow(
                        borrowDto.getId(),
                        borrowDto.getBorrowDateTime(),
                        borrowDto.getReturnDateTime()
                )).collect(Collectors.toList());
    }

    public List<BorrowDto> mapToBorrowDtoList(final List<Borrow> borrowList) {
        return borrowList.stream()
                .map(borrow -> new BorrowDto(
                        borrow.getId(),
                        borrow.getBorrowDateTime(),
                        borrow.getReturnDateTime()
                )).collect(Collectors.toList());
    }
}
