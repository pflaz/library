package com.crud.library.mapper;

import com.crud.library.domain.Reader;
import com.crud.library.dto.ReaderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReaderMapper {
    @Autowired
    private BorrowMapper borrowMapper;

    public Reader mapToReader(final ReaderDto readerDto) {
        return new Reader(
                readerDto.getId(),
                readerDto.getFirstName(),
                readerDto.getLastName(),
                readerDto.getCreated(),
                borrowMapper.mapToBorrowList(readerDto.getBorrowDtoList())
        );
    }

    public ReaderDto mapToReaderDto(final Reader reader) {
        return new ReaderDto(
                reader.getId(),
                reader.getFirstName(),
                reader.getLastName(),
                reader.getCreated(),
                borrowMapper.mapToBorrowDtoList(reader.getBorrowList())
        );
    }

    public List<Reader> mapToReaderList(final List<ReaderDto> readerDtoList) {
        return readerDtoList.stream()
                .map(readerDto -> new Reader(
                        readerDto.getId(),
                        readerDto.getFirstName(),
                        readerDto.getLastName(),
                        readerDto.getCreated(),
                        borrowMapper.mapToBorrowList(readerDto.getBorrowDtoList())
                        ))
                .collect(Collectors.toList());
    }

    public List<ReaderDto> mapToReaderDtoList(final List<Reader> readerList) {
        return readerList.stream()
                .map(reader -> new ReaderDto(
                        reader.getId(),
                        reader.getFirstName(),
                        reader.getLastName(),
                        reader.getCreated(),
                        borrowMapper.mapToBorrowDtoList(reader.getBorrowList())
                ))
                .collect(Collectors.toList());
    }
}
