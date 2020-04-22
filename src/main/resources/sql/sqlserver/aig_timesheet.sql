

CREATE TABLE [dbo].[aig_timesheet](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[user_name] [varchar](100) NOT NULL,
	[application_no] [varchar](20) NOT NULL,
	[year] [varchar](10) NOT NULL,
	[month] [varchar](10) NOT NULL,
	[day1] [varchar](5) NULL DEFAULT (NULL),
	[day2] [varchar](5) NULL DEFAULT (NULL),
	[day3] [varchar](5) NULL DEFAULT (NULL),
	[day4] [varchar](5) NULL DEFAULT (NULL),
	[day5] [varchar](5) NULL DEFAULT (NULL),
	[day6] [varchar](5) NULL DEFAULT (NULL),
	[day7] [varchar](5) NULL DEFAULT (NULL),
	[day8] [varchar](5) NULL DEFAULT (NULL),
	[day9] [varchar](5) NULL DEFAULT (NULL),
	[day10] [varchar](5) NULL DEFAULT (NULL),
	[day11] [varchar](5) NULL DEFAULT (NULL),
	[day12] [varchar](5) NULL DEFAULT (NULL),
	[day13] [varchar](5) NULL DEFAULT (NULL),
	[day14] [varchar](5) NULL DEFAULT (NULL),
	[day15] [varchar](5) NULL DEFAULT (NULL),
	[day16] [varchar](5) NULL DEFAULT (NULL),
	[day17] [varchar](5) NULL DEFAULT (NULL),
	[day18] [varchar](5) NULL DEFAULT (NULL),
	[day19] [varchar](5) NULL DEFAULT (NULL),
	[day20] [varchar](5) NULL DEFAULT (NULL),
	[day21] [varchar](5) NULL DEFAULT (NULL),
	[day22] [varchar](5) NULL DEFAULT (NULL),
	[day23] [varchar](5) NULL DEFAULT (NULL),
	[day24] [varchar](5) NULL DEFAULT (NULL),
	[day25] [varchar](5) NULL DEFAULT (NULL),
	[day26] [varchar](5) NULL DEFAULT (NULL),
	[day27] [varchar](5) NULL DEFAULT (NULL),
	[day28] [varchar](5) NULL DEFAULT (NULL),
	[day29] [varchar](5) NULL DEFAULT (NULL),
	[day30] [varchar](5) NULL DEFAULT (NULL),
	[day31] [varchar](5) NULL DEFAULT (NULL),
	[created_date] [datetime] NOT NULL,
	[created_by] [varchar](100) NOT NULL,
	[update_date] [datetime] NOT NULL,
	[update_by] [varchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO


