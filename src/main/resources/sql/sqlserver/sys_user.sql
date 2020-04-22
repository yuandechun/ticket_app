

CREATE TABLE [dbo].[aig_user](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[user_name] [varchar](100) NOT NULL,
	[password] [varchar](100) NOT NULL,
	[email] [varchar](50) NULL DEFAULT (NULL),
	[phone] [varchar](20) NULL DEFAULT (NULL),
	[address] [varchar](500) NULL DEFAULT (NULL),
	[remarks] [varchar](500) NULL DEFAULT (NULL),
	[timestamp] [datetime] NOT NULL DEFAULT (getdate())
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO


