package com.crud.library.mapper;

import com.crud.library.domain.Title;
import com.crud.library.domain.TitleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TitleMapper {
    @Autowired
    ItemMapper itemMapper;
    public Title mapToTitle(TitleDto titleDto) {
        return new Title(
                titleDto.getId(),
                titleDto.getTitle(),
                titleDto.getAuthor(),
                titleDto.getReleaseYear(),
                itemMapper.mapToItemList(titleDto.getItemDtoList())
        );
    }

    public TitleDto mapToTitleDto(Title title) {
        return new TitleDto(
            title.getId(),
                title.getTitle(),
                title.getAuthor(),
                title.getReleaseYear(),
                itemMapper.mapToItemDtoList(title.getItemList())
        );
    }

    public List<TitleDto> mapToTitleDtoList(List<Title> titleList) {
        return titleList.stream()
                .map(title -> new TitleDto(
                        title.getId(),
                        title.getTitle(),
                        title.getAuthor(),
                        title.getReleaseYear(),
                        itemMapper.mapToItemDtoList(title.getItemList())
                ))
                .collect(Collectors.toList());
    }

    public List<Title> mapToTitleList(List<TitleDto> titleDtoList) {
        return titleDtoList.stream()
                .map(titleDto -> new Title(
                        titleDto.getId(),
                        titleDto.getTitle(),
                        titleDto.getAuthor(),
                        titleDto.getReleaseYear(),
                        itemMapper.mapToItemList(titleDto.getItemDtoList())
                ))
                .collect(Collectors.toList());
    }
}
