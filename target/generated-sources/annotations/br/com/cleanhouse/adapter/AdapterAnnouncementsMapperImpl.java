package br.com.cleanhouse.adapter;

import br.com.cleanhouse.dto.announcement.AcceptedPaymentsEnumDto;
import br.com.cleanhouse.dto.announcement.AnnouncementMaidDto;
import br.com.cleanhouse.dto.announcement.DaysOfWeekAvailableEnumDto;
import br.com.cleanhouse.entity.enums.AcceptedPaymentsEnum;
import br.com.cleanhouse.entity.enums.DaysOfWeekAvailableEnum;
import br.com.cleanhouse.entity.maid.AnnouncementMaid;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-14T13:59:25-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class AdapterAnnouncementsMapperImpl implements AdapterAnnouncementsMapper {

    @Override
    public AnnouncementMaid convertDtoToEntityMaid(AnnouncementMaidDto announcementMaidDto) {
        if ( announcementMaidDto == null ) {
            return null;
        }

        AnnouncementMaid announcementMaid = new AnnouncementMaid();

        announcementMaid.setLogin( announcementMaidDto.getLogin() );
        announcementMaid.setAvailableSchedule( daysOfWeekAvailableEnumDtoListToDaysOfWeekAvailableEnumList( announcementMaidDto.getAvailableSchedule() ) );
        announcementMaid.setAcceptedPayments( acceptedPaymentsEnumDtoListToAcceptedPaymentsEnumList( announcementMaidDto.getAcceptedPayments() ) );
        announcementMaid.setLocomotionPaidOfClient( announcementMaidDto.isLocomotionPaidOfClient() );
        announcementMaid.setComments( announcementMaidDto.getComments() );

        return announcementMaid;
    }

    protected DaysOfWeekAvailableEnum daysOfWeekAvailableEnumDtoToDaysOfWeekAvailableEnum(DaysOfWeekAvailableEnumDto daysOfWeekAvailableEnumDto) {
        if ( daysOfWeekAvailableEnumDto == null ) {
            return null;
        }

        DaysOfWeekAvailableEnum daysOfWeekAvailableEnum;

        switch ( daysOfWeekAvailableEnumDto ) {
            case MONDAY: daysOfWeekAvailableEnum = DaysOfWeekAvailableEnum.MONDAY;
            break;
            case TUESDAY: daysOfWeekAvailableEnum = DaysOfWeekAvailableEnum.TUESDAY;
            break;
            case WEDNESDAY: daysOfWeekAvailableEnum = DaysOfWeekAvailableEnum.WEDNESDAY;
            break;
            case THURSDAY: daysOfWeekAvailableEnum = DaysOfWeekAvailableEnum.THURSDAY;
            break;
            case FRIDAY: daysOfWeekAvailableEnum = DaysOfWeekAvailableEnum.FRIDAY;
            break;
            case SATURDAY: daysOfWeekAvailableEnum = DaysOfWeekAvailableEnum.SATURDAY;
            break;
            case SUNDAY: daysOfWeekAvailableEnum = DaysOfWeekAvailableEnum.SUNDAY;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + daysOfWeekAvailableEnumDto );
        }

        return daysOfWeekAvailableEnum;
    }

    protected List<DaysOfWeekAvailableEnum> daysOfWeekAvailableEnumDtoListToDaysOfWeekAvailableEnumList(List<DaysOfWeekAvailableEnumDto> list) {
        if ( list == null ) {
            return null;
        }

        List<DaysOfWeekAvailableEnum> list1 = new ArrayList<DaysOfWeekAvailableEnum>( list.size() );
        for ( DaysOfWeekAvailableEnumDto daysOfWeekAvailableEnumDto : list ) {
            list1.add( daysOfWeekAvailableEnumDtoToDaysOfWeekAvailableEnum( daysOfWeekAvailableEnumDto ) );
        }

        return list1;
    }

    protected AcceptedPaymentsEnum acceptedPaymentsEnumDtoToAcceptedPaymentsEnum(AcceptedPaymentsEnumDto acceptedPaymentsEnumDto) {
        if ( acceptedPaymentsEnumDto == null ) {
            return null;
        }

        AcceptedPaymentsEnum acceptedPaymentsEnum;

        switch ( acceptedPaymentsEnumDto ) {
            case CREDIT_CARD: acceptedPaymentsEnum = AcceptedPaymentsEnum.CREDIT_CARD;
            break;
            case DEBIT_CARD: acceptedPaymentsEnum = AcceptedPaymentsEnum.DEBIT_CARD;
            break;
            case IN_CASH: acceptedPaymentsEnum = AcceptedPaymentsEnum.IN_CASH;
            break;
            case PIX: acceptedPaymentsEnum = AcceptedPaymentsEnum.PIX;
            break;
            case BANK_TRANSFERS: acceptedPaymentsEnum = AcceptedPaymentsEnum.BANK_TRANSFERS;
            break;
            case CHECK_BOOK: acceptedPaymentsEnum = AcceptedPaymentsEnum.CHECK_BOOK;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + acceptedPaymentsEnumDto );
        }

        return acceptedPaymentsEnum;
    }

    protected List<AcceptedPaymentsEnum> acceptedPaymentsEnumDtoListToAcceptedPaymentsEnumList(List<AcceptedPaymentsEnumDto> list) {
        if ( list == null ) {
            return null;
        }

        List<AcceptedPaymentsEnum> list1 = new ArrayList<AcceptedPaymentsEnum>( list.size() );
        for ( AcceptedPaymentsEnumDto acceptedPaymentsEnumDto : list ) {
            list1.add( acceptedPaymentsEnumDtoToAcceptedPaymentsEnum( acceptedPaymentsEnumDto ) );
        }

        return list1;
    }
}
