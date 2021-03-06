package com.guicedee.guicedservlets.services;

import com.guicedee.guicedinjection.interfaces.IDefaultBinder;

import jakarta.validation.constraints.NotNull;
import java.util.Comparator;

public interface IGuiceSiteBinder<M extends GuiceSiteInjectorModule>
		extends Comparable<IGuiceSiteBinder>, Comparator<IGuiceSiteBinder>, IDefaultBinder<M>
{
	@Override
	default int compare(IGuiceSiteBinder o1, IGuiceSiteBinder o2)
	{
		if (o1 == null || o2 == null)
		{
			return -1;
		}
		return o1.sortOrder()
		         .compareTo(o2.sortOrder());
	}

	default Integer sortOrder()
	{
		return 100;
	}

	@Override
	default int compareTo(@NotNull IGuiceSiteBinder o)
	{
		int sort = sortOrder().compareTo(o.sortOrder());
		if (sort == 0)
		{
			return -1;
		}
		return sort;
	}
}
